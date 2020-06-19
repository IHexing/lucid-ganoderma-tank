package cn.ihexing.netity;

import cn.ihexing.util.SpringUtils;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.InternetHeaders;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * ʚ•⚇•ɞ
 *
 * @Description: 客户端
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 21:07
 */
public class InternetClient {
    private String host;
    private int port;
    private ChannelHandler childHandler;
    private Environment env = SpringUtils.getBean(Environment.class);

    public InternetClient(ChannelHandler childHandler) {
        this.childHandler = childHandler;
        this.host = env.getProperty("tank.server.host");
        this.port = Integer.parseInt(Objects.requireNonNull(env.getProperty("tank.server.port")));
    }

    public void connect() {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(1);
        try {
            //创建服务器端的启动对象，配置参数
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup).channel(NioSocketChannel.class).handler(childHandler);
            //绑定一个端口并且同步, 生成了一个 ChannelFuture 对象
            ChannelFuture future = bootstrap.connect(this.host, this.port).sync();
            //对关闭通道进行监听
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}

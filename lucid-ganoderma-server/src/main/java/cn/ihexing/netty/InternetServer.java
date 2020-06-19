package cn.ihexing.netty;

import cn.ihexing.util.SpringUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.springframework.core.env.Environment;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:09
 */
public class InternetServer {

    private int port;
    private ChannelHandler childHandler;
    private Environment env = SpringUtils.getBean(Environment.class);

    public InternetServer(ChannelHandler childHandler) {
        this.childHandler = childHandler;
        this.port = Integer.parseInt(Objects.requireNonNull(env.getProperty("tank.server.port")));
    }

    public void connect() {
        ThreadFactory threadFactory = new DefaultThreadFactory("Tank-Server");
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(20, threadFactory);
        //创建服务器端的启动对象，配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();

        try {
            //使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class) //使用NioSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    .childHandler(childHandler);
            //绑定一个端口并且同步, 生成了一个 ChannelFuture 对象
            ChannelFuture cf = bootstrap.bind(port).sync();
            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

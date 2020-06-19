package cn.ihexing.netty;

import cn.ihexing.context.TankPipline;
import cn.ihexing.context.TankRegistry;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:18
 */
public class InternetInternet extends ChannelInitializer<SocketChannel> {
    private TankPipline tankPipline;
    private TankRegistry tankRegistry;

    public InternetInternet(TankPipline tankPipline, TankRegistry tankRegistry) {
        this.tankPipline = tankPipline;
        this.tankRegistry = tankRegistry;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("InternetHeader", new InternetHeader(tankPipline, tankRegistry));
    }
}

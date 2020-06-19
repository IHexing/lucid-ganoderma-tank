package cn.ihexing.netity;


import cn.ihexing.context.TankPipline;
import cn.ihexing.context.TankRegistry;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import java.rmi.registry.Registry;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 21:32
 */
public class InternetInternet extends ChannelInitializer<SocketChannel> {
    private TankPipline tankPipline;

    public InternetInternet(TankPipline tankPipline) {
        this.tankPipline = tankPipline;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("internetHeader", new InternetHeader(tankPipline));//添加自定义处理器
    }
}

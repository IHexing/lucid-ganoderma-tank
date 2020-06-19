package cn.ihexing.netty;

import cn.ihexing.context.TankMsg;
import cn.ihexing.context.TankPipline;
import cn.ihexing.context.TankRegistry;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:18
 */
public class InternetHeader extends SimpleChannelInboundHandler<TankMsg> {

    private TankPipline tankPipline;
    private TankRegistry tankRegistry;

    public InternetHeader(TankPipline tankPipline, TankRegistry tankRegistry) {
        this.tankPipline = tankPipline;
        this.tankRegistry = tankRegistry;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TankMsg msg) throws Exception {
        String channelId = ctx.channel().id().asLongText();
        if (!this.tankRegistry.isRegistry(channelId)) {
            this.tankRegistry.registry(ctx.channel().id().asLongText(), ctx);
        }
        tankPipline.invoke(msg);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().asLongText();
        this.tankRegistry.remove(channelId);
    }

}

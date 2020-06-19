package cn.ihexing.netity;


import cn.ihexing.context.TankPipline;
import cn.ihexing.context.TankRegistry;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 21:32
 */
public class InternetHeader extends SimpleChannelInboundHandler<Object> {

    private TankPipline tankPipline;

    public InternetHeader(TankPipline tankPipline) {
        this.tankPipline = tankPipline;
    }

    /**
     * 读取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    /**
     * 连接成功
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }
}

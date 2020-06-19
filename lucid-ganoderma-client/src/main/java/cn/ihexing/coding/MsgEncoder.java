package cn.ihexing.coding;

import cn.ihexing.context.TankMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * ʚ•⚇•ɞ
 *
 * @Description: 编码器
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:29
 */
public class MsgEncoder extends MessageToByteEncoder<TankMsg> {
    @Override
    protected void encode(ChannelHandlerContext ctx, TankMsg msg, ByteBuf out) throws Exception {

    }
}

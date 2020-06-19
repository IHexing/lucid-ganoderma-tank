package cn.ihexing.coding;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * ʚ•⚇•ɞ
 *
 * @Description: 解码器
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:29
 */
public class MsgDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    }
}

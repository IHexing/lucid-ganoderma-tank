package cn.ihexing.netty.registry;

import cn.ihexing.context.TankRegistry;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * ʚ•⚇•ɞ
 *
 * @Description: 连接管理类
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:37
 */
public class ChannelHandlerRegistry implements TankRegistry<ChannelHandlerContext> {

    Map<String, ChannelHandlerContext> map = new WeakHashMap<>();

    /**
     * 存储连接
     *
     * @param id
     * @param channelHandlerContext
     * @return
     */
    @Override
    public boolean registry(String id, ChannelHandlerContext channelHandlerContext) {
        map.put(id, channelHandlerContext);
        return true;
    }

    @Override
    public void remove(String channelId) {
        this.map.remove(channelId);
    }

    @Override
    public ChannelHandlerContext get(String id) {
        return this.map.get(id);
    }

    @Override
    public boolean isRegistry(String id) {
        return this.map.containsKey(id);
    }
}

package cn.ihexing.context;

import cn.ihexing.comm.MsgType;

/**
 * ʚ•⚇•ɞ
 *
 * @Description: 抽象的消息类
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:27
 */
public abstract class TankMsg {
    /**
     * 获取消息类型
     *
     * @return
     */
    public abstract MsgType getMsgType();
}

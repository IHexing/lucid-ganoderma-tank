package cn.ihexing.context;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 22:53
 */
public interface TankHandler {

    /**
     * 设置 TankHandler
     *
     * @param apolloHandler
     */
    void setNext(TankHandler apolloHandler);

    /**
     * 获取下一个处理 节点
     *
     * @return
     */
    TankHandler getNext();

}

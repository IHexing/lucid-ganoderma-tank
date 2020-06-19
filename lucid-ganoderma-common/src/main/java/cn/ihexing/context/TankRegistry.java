package cn.ihexing.context;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 21:58
 */
public interface TankRegistry<T> {
    /**
     * 注册
     *
     * @param id
     * @param t
     * @return
     */
    boolean registry(String id, T t);

    /**
     * 注销
     *
     * @param channelId
     */
    void remove(String channelId);

    /**
     * 获取
     *
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 是否存在
     *
     * @param id
     * @return
     */
    boolean isRegistry(String id);
}

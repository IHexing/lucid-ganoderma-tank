package cn.ihexing.singleton;

/**
 * ʚ•⚇•ɞ
 *
 *
 * @Description:
 * @author: Hexing
 * @contact: Hx@IHexing.cn
 * @time: 2020-06-23 17:03 周二
 */
public enum  Singleton8 {
    SINGLETON_8;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(SINGLETON_8.hashCode());
            }).start();
        }
    }
}

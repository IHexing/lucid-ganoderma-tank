package cn.ihexing.singleton;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: Hexing
 * @contact: Hx@IHexing.cn
 * @time: 2020-06-23 16:37 周二
 */
public class Singleton1 {
    private Singleton1() {

    }

    private final static Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}

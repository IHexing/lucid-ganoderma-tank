package cn.ihexing.singleton;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: Hexing
 * @contact: Hx@IHexing.cn
 * @time: 2020-06-23 17:01 周二
 */
public class Singleton7 {
    private Singleton7() {

    }

    private static class aaa {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    private static Singleton7 INSTANCE;

    public static Singleton7 getInstance() {
        return aaa.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}

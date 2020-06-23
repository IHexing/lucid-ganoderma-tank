package cn.ihexing.singleton;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: Hexing
 * @contact: Hx@IHexing.cn
 * @time: 2020-06-23 16:54 周二
 */
public class Singleton5 {
    private Singleton5() {

    }

    private static Singleton5 INSTANCE;

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton5.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton5();
            }
        }
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

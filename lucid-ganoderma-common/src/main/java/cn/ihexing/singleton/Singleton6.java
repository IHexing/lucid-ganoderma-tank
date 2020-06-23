package cn.ihexing.singleton;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: Hexing
 * @contact: Hx@IHexing.cn
 * @time: 2020-06-23 16:57 周二
 */
public class Singleton6 {
    private Singleton6() {

    }

    private static Singleton6 INSTANCE;

    public static Singleton6 getInstance() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Singleton6.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (INSTANCE == null) {
                    INSTANCE = new Singleton6();
                }
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

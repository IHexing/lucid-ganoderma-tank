package cn.ihexing.singleton;

import com.sun.org.apache.bcel.internal.generic.MULTIANEWARRAY;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: Hexing
 * @contact: Hx@IHexing.cn
 * @time: 2020-06-23 16:52 周二
 */
public class Singleton4 {
    private Singleton4() {

    }

    private static Singleton4 INSTANCE;

    public static synchronized Singleton4 getInstance() {
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
            INSTANCE = new Singleton4();
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

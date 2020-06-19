package cn.ihexing.context;

import cn.ihexing.netity.InternetClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 21:06
 */
@Component
public class GameContext implements CommandLineRunner {
    InternetClient internetClient;

    public GameContext(InternetClient internetClient) {
        this.internetClient = internetClient;
    }

    @Override
    public void run(String... args) throws Exception {
        this.internetClient.connect();//启动netty客户端
    }
}

package cn.ihexing.context;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ʚ•⚇•ɞ
 *
 * @Description:
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 20:49
 */
@Component
public class GameContext implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动222");
    }
}

package cn.ihexing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ʚ•⚇•ɞ
 *
 * @Description: 启动类
 * @author: hexing
 * @contact: hx@ihexing.cn
 * @time: 2020/6/19 17:26
 */
@SpringBootApplication
@Slf4j
public class ApplicationTankStart implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTankStart.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("启动成功");
    }
}

package cn.ihexing.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * ʚ•⚇•ɞ
 *
 * @Description: spring工具类 方便在非spring管理环境中获取bean
 * @author: hexing
 * @contact: hx@cn.ihexing.cn
 * @time: 2020/5/29 13:53
 */
@Component
public class SpringUtils implements BeanFactoryPostProcessor {
    /**
     * Spring应用上下文环境
     */
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        beanFactory = factory;
    }

    /**
     * 获取对象
     *
     * @param name benn NAME
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * 获取对象 根据类型
     *
     * @param clz
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        return (T) beanFactory.getBean(clz);
    }
}

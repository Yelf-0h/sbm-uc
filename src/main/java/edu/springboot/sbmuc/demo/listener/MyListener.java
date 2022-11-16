package edu.springboot.sbmuc.demo.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义Listener类
 * 也可直接@WebListener
 *
 * @author Yefl
 * @date 2022/11/16
 */
@Component
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("【注意】本行是由上下文监听器MyListener生成的：上下文已经初始化完成。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("【注意】本行是由上下文监听器MyListener生成的：上下文已经销毁完成。");
    }
}
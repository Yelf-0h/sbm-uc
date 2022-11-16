package edu.springboot.sbmuc.config;

import edu.springboot.sbmuc.demo.filter.MyFilter;
import edu.springboot.sbmuc.demo.listener.MyListener;
import edu.springboot.sbmuc.demo.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Yelf
 * @create 2022-11-16-19:14
 */
@Configuration
public class WebServletConfig {

    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
        ServletRegistrationBean registrationBean = null;
        registrationBean = new ServletRegistrationBean(myServlet,"/demo/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilter(MyFilter myFilter){
        FilterRegistrationBean registrationBean = null;
        registrationBean = new FilterRegistrationBean(myFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/demo/toLoginPage","/demo/myServlet"));
        return registrationBean;

    }

    @Bean
    public ServletListenerRegistrationBean getServletListener(MyListener myListener){
        ServletListenerRegistrationBean registrationBean = null;
        registrationBean = new ServletListenerRegistrationBean(myListener);
        return registrationBean;
    }
}

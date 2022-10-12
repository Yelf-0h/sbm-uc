package edu.springboot.sbmuc.config;

import com.alibaba.druid.pool.DruidDataSource;
import edu.springboot.sbmuc.intercept.LoginInterceptHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author Yelf
 * @create 2022-09-07-8:39
 */
@Configuration
public class DataSourceConfig implements WebMvcConfigurer {

   /* @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource DruidDataSource(){
        DataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }*/

    @Autowired
    private LoginInterceptHandler loginInterceptHandler;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器,并设置拦截的请求路径
        //addPathPatterns为拦截此请求路径的请求
        //excludePathPatterns为不拦截此路径的请求
        registry.addInterceptor(loginInterceptHandler)
                .addPathPatterns("/area35a/*")
                .excludePathPatterns("/area35a/Login")
                .excludePathPatterns("/area35a/ValidateCode")
                .excludePathPatterns("/area35a/Login_loginDeal");
    }
}

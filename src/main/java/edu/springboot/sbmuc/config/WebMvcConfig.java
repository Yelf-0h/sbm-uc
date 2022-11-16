package edu.springboot.sbmuc.config;

import edu.springboot.sbmuc.intercept.ApiAuthorizationInterceptor;
import edu.springboot.sbmuc.intercept.LoginInterceptHandler;
import edu.springboot.sbmuc.ui.ctrl35a.UIConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yelf
 * @create 2022-09-07-8:39
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

   /* @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource DruidDataSource(){
        DataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }*/

    @Autowired
    private LoginInterceptHandler loginInterceptHandler;
    @Autowired
    private ApiAuthorizationInterceptor ApiAuthorizationInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器,并设置拦截的请求路径
        //addPathPatterns为拦截此请求路径的请求
        //excludePathPatterns为不拦截此路径的请求
        registry.addInterceptor(loginInterceptHandler)
                .addPathPatterns(UIConst.AREAPATH+"/Main*")
                .addPathPatterns(UIConst.AREAPATH+"/Member*");
        registry.addInterceptor(ApiAuthorizationInterceptor)
                .addPathPatterns(UIConst.AREAPATH+"/Api*")
                .excludePathPatterns(UIConst.AREAPATH+"/Api_err");
    }


}

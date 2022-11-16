package edu.springboot.sbmuc.demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 我过滤器
 * 自定义Filter类
 * 也可直接@WebFilter(value = {"/demo/toLoginPage","/demo/myServlet"})
 * @author Yefl
 * @date 2022/11/16
 */
@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse
            servletResponse,
                         FilterChain filterChain) throws IOException,
            ServletException {
        System.out.println("【注意】本行是由过滤器MyFilter生成的。");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}

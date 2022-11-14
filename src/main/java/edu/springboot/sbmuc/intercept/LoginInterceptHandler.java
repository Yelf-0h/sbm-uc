package edu.springboot.sbmuc.intercept;

import edu.springboot.sbmuc.ui.ctrl35a.BaseController;
import edu.springboot.sbmuc.ui.ctrl35a.UIConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 * @author Yelf
 * @create 2022-10-12-9:13
 */
@Component
@Slf4j
public class LoginInterceptHandler implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath();
        String currUrl = URLEncoder.encode(request.getServletPath().toString(),"UTF-8");
        HttpSession session= request.getSession();
        System.out.println("LoginInterceptHandler.preHandle():");



        if (request.getSession().getAttribute(UIConst.BG_LOGINUSER_KEY) == null) {
            // 跳转到登录页面
            String loginUrl = contextPath + "/" +UIConst.AREANAME + "/Login";
            loginUrl += "?redirectUrl=" + currUrl;
            response.sendRedirect(loginUrl);
            request.setAttribute("msg", "您没有权限进行此操作，请先登陆！");
            return false;
        }else {
            return true;
        }
    }
}

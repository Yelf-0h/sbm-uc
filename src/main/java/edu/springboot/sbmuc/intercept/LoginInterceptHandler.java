package edu.springboot.sbmuc.intercept;

import edu.springboot.sbmuc.ui.ctrl35a.BaseController;
import edu.springboot.sbmuc.ui.ctrl35a.UIConst;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yelf
 * @create 2022-10-12-9:13
 */
@Component
public class LoginInterceptHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute(UIConst.BG_LOGINUSER_KEY) == null) {
            // 跳转到登录页面
            request.setAttribute("msg", "您没有权限进行此操作，请先登陆！");
            response.sendRedirect(request.getContextPath() + "/area35a/Login");
            return false;
        }else {
            return true;
        }
    }
}

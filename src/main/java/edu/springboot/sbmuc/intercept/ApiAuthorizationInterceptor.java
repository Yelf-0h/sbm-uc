package edu.springboot.sbmuc.intercept;

import edu.springboot.sbmuc.ui.ctrl35a.UIConst;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * api授权拦截器
 *
 * @author Yefl
 * @date 2022/11/14
 */
@Component
public class ApiAuthorizationInterceptor implements org.springframework.web.servlet.HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath ();
        String currUrl = java.net.URLEncoder.encode(request.getServletPath().toString(), "UTF-8");
        HttpSession session = request.getSession();
        System.out.print ("ApiAuthorizationInterceptor: ");
        if (session.getAttribute(UIConst.BG_LOGINUSER_KEY) == null) {
            String errUrl = contextPath + "/" + UIConst.AREANAME + "/Api_err";
            errUrl += "?currUrl=" + currUrl;
            response.sendRedirect(errUrl);
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;

    }
}

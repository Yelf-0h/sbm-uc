package edu.springboot.sbmuc.demo.servlet;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 我的servlet
 *
 * @author Yefl
 * @date 2022/11/16
 */
@Component
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
// ***** 防止乱码的解决方案
// 输入数据乱码解决方案：使用request对象获取浏览器提供数据前，先设置字符集
        request.setCharacterEncoding("utf-8");
// 输入数据乱码解决方案：使用request输出数据前，先设置字符集和内容类型
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
// ***** Servlet的doxxx方法中的6个标准对象（含request和response）
// 从request里获取session对象和application对象
        javax.servlet.http.HttpSession session = request.getSession();
        javax.servlet.ServletContext application = request.getServletContext();
// 调用继承的方法来获取config对象
        javax.servlet.ServletConfig config = getServletConfig();
// 从response对象里获取out对象——response.getWriter()之前，要先设置页面的编码
        java.io.PrintWriter out = response.getWriter();
        /* ----------------------------------------------------------------- */
        out.write("Hello 龙岩学院!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        doGet(request, response);
    }
}
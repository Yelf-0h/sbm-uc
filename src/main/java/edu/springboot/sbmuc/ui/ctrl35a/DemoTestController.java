package edu.springboot.sbmuc.ui.ctrl35a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(UIConst.AREAPATH)
@Controller
public class DemoTestController extends BaseController {
    /**
     * 各方法的路径的Bean的前缀
     */
    public final static String BEAN_PREFIX = "/Demo_";

    public DemoTestController() {
        super();
        System.out.println(this);
    }

    @RequestMapping(BEAN_PREFIX + "test01")
    protected String test01(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        request.setAttribute("Pub_RealPath",
                request.getServletContext().getRealPath("/"));
        return getDispatcherPath("Demo", "test01");
    }

    @RequestMapping(BEAN_PREFIX + "test02")
    protected String test02(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        request.setAttribute("Pub_RealPath",
                request.getServletContext().getRealPath("/"));
        return getDispatcherPath("Demo", "test02");
    }

    @RequestMapping(BEAN_PREFIX + "test03")
    protected String test03(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        return getDispatcherPath("Demo", "test03");
    }

    @RequestMapping(BEAN_PREFIX + "test04")
    protected String test04(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        java.io.File file = new
                java.io.File(request.getServletContext().getRealPath("up"));
        String[] listFile = file.list();
        request.setAttribute("listFile", listFile);
        return getDispatcherPath("Demo", "test04");
    }

    @RequestMapping(BEAN_PREFIX + "test05")
    protected String test05(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        return getDispatcherPath("Demo", "test05");
    }

    @RequestMapping(BEAN_PREFIX + "test06")
    protected String test06(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        return getDispatcherPath("Demo", "test06");
    }

    @RequestMapping(BEAN_PREFIX + "test07")
    protected String test07(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        return getDispatcherPath("Demo", "test07");
    }

    @RequestMapping(BEAN_PREFIX + "test08")
    protected String test08(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        return getDispatcherPath("Demo", "test08");
    }

    @RequestMapping(BEAN_PREFIX + "test09")
    protected String test09(HttpServletRequest request, HttpServletResponse
            response) {
        handleBase(request, response); //处理area相关变量
        return getDispatcherPath("Demo", "test09");
    }
}

package edu.springboot.sbmuc.ui.ctrl35a;

import com.liuvei.common.RspResult;
import edu.springboot.sbmuc.pojo.Member;
import edu.springboot.sbmuc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Yelf
 * @create 2022-11-14-11:19
 */
@Controller
@RequestMapping(UIConst.AREAPATH)
public class DemoJsonController extends BaseController {

    @Autowired
    private MemberService memberService;

    public final static String BEAN_PREFIX = "/Demo_";
    /**
     * 默认视图改为MappingJackson2JsonView后，将把模型对象转为json字符串输出
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = BEAN_PREFIX + "json01")
    protected ModelAndView json01(HttpServletRequest request, HttpServletResponse
            response)throws Exception{
//调用基类的处理
        ModelAndView mView = super.handleBase(request, response);
//java的List对象
        List<Member> vList = memberService.list();
        String strResult =null;
        RspResult result = new RspResult().resetOk();
        result.setData(vList);
//添加放到作用域的对象
        mView.addObject(result);
//默认视图改为MappingJackson2JsonView
        mView.setView(new MappingJackson2JsonView());
        return mView;
    }

    /**
     * 【RequestBody注解和ResponseBody注解处理json】
     * 1)注解处理json要使用SpringMVC的消息转换器
     * 2）默认的消息转换器使用jackjson，需要添加jsckson的三个jar包
     * param request
     *
     * @param response
     * @return
     */
    @RequestMapping(value = BEAN_PREFIX + "json02")
    @ResponseBody
    protected Object json02(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request, response);
        RspResult result = new RspResult();
//java的List对象
        List<Member> vList = memberService.list();
        result.setData(vList);
        return result.resetOk();
    }
}

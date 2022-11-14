package edu.springboot.sbmuc.ui.ctrl35a;

import com.liuvei.common.RspResult;
import com.liuvei.common.SysFun;
import edu.springboot.sbmuc.pojo.Member;
import edu.springboot.sbmuc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Yelf
 * @create 2022-11-14-11:34
 */
@Controller
@RequestMapping(UIConst.AREANAME)
public class ApiController extends BaseController {

    public static final String BEAN_PREFIX = "/Api_";
    @Autowired
    private MemberService memberService;

    @RequestMapping(BEAN_PREFIX+"data")
    @ResponseBody
    protected Object data(HttpServletRequest request, HttpServletResponse response){
        handleBase(request,response);
        ModelAndView mView = super.handleBase(request, response);
        List<Member> vList = memberService.list();
        RspResult result = new RspResult().resetOk();

        result.setData(vList);

        return result;

    }
    @RequestMapping(BEAN_PREFIX+"err")
    @ResponseBody
    protected Object err(HttpServletRequest request, HttpServletResponse response){
        handleBase(request,response);
        ModelAndView mView = super.handleBase(request, response);
        RspResult result = new RspResult().resetNo();
        String strDesc = "Api调用出错，可能是没有登录，请确定。";
        String currUrl = request.getParameter("currUrl");
        if (!SysFun.isNullOrEmpty(currUrl)){
            strDesc += "当前访问的url是————————"+currUrl+"。";
        }
        result.setDesc(strDesc);
        return result;
    }

}

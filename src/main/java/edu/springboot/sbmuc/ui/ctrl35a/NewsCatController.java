package edu.springboot.sbmuc.ui.ctrl35a;

import com.liuvei.common.PagerItem;
import com.liuvei.common.SysFun;
import edu.springboot.sbmuc.pojo.NewsCat;
import edu.springboot.sbmuc.service.NewsCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Yelf
 * @create 2022-11-02-20:03
 */
@Controller
@RequestMapping(UIConst.AREAPATH)
public class NewsCatController extends CrudController{

    @Autowired
    private NewsCatService newsCatService;

    public NewsCatController() {
        super();
    }

    /**
     * 各方法的路径的Bean的前缀
     */
    public final static String BEAN_PREFIX = "/NewsCat_";


    @Override
    @RequestMapping(BEAN_PREFIX + "list")
    protected ModelAndView listView(HttpServletRequest request,
                                    HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat", "list");
        List<NewsCat> vDataList = null;
        // ---------------------------------------------------------------------
        // 分页步骤1. 创建PagerIter对象, 处理url传过来的pagesize和pageindex
        PagerItem pagerItem = new PagerItem();
        pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
        pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
        // 分页步骤2.1. 定义记录数变量
        Long rowCount = 0L;
        // 分页步骤2.2. 根据条件，查找符合条件的所有记录数 ***** count()要根据实际换成其它方法
        rowCount = newsCatService.count();
        // 分页步骤2.3. 将记录数赋给pagerItem，以便进行分页的各类计算
        pagerItem.changeRowCount(rowCount);
        // 分页步骤2.4. 从数据库取指定分页的数据 ***** pager()要根据实际换成其它方法
        vDataList = newsCatService.pager(pagerItem.getPageNum(),pagerItem.getPageSize());
        // 分页步骤2.5. 设置页面的跳转url
        pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(),request.getQueryString()));
        // 分页步骤3. 将分页对象和数据列表,放到作用域,以便页面可以访问
        request.setAttribute("pagerItem", pagerItem);
        request.setAttribute("DataList", vDataList);
        // ---------------------------------------------------------------------
        // 转发到列表页面
        mView.setViewName(getDispatcherPath("NewsCat", "list"));
        return mView;
    }

    @Override
    @RequestMapping(BEAN_PREFIX+"listDeal")
    protected ModelAndView listDeal(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat","list");
        String name = request.getParameter("catName");
        request.setAttribute("catName",name);
        if (!SysFun.isNullOrEmpty(name)){
            name = name.trim();
        }else {
            name = "";
        }
        List<NewsCat> vDataList = null;

        PagerItem pagerItem = new PagerItem();
        pagerItem.parsePageSize(request.getParameter(pagerItem.getParamPageSize()));
        pagerItem.parsePageNum(request.getParameter(pagerItem.getParamPageNum()));
        Long rowCount = 0L;
        if (!SysFun.isNullOrEmpty(name)){
            rowCount = newsCatService.countByName(name);
            pagerItem.changeRowCount(rowCount);
            vDataList = newsCatService.pagerByName(name, pagerItem.getPageNum(), pagerItem.getPageSize());
        }else {
            rowCount = newsCatService.count();
            pagerItem.changeRowCount(rowCount);
            vDataList = newsCatService.pager(pagerItem.getPageNum(), pagerItem.getPageSize());
        }
        pagerItem.changeUrl(SysFun.generalUrl(request.getRequestURI(),request.getQueryString()));
        request.setAttribute("pagerItem",pagerItem);
        request.setAttribute("DataList",vDataList);

        mView.setViewName(getDispatcherPath("NewsCat","list"));
        return mView;
    }

    @Override
    @RequestMapping(BEAN_PREFIX+"insert")
    protected ModelAndView insertView(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat","insert");
        return mView;
    }

    @Override
    @RequestMapping(BEAN_PREFIX+"insertDeal")
    protected ModelAndView insertDeal(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat","insert");
        HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();

        String catName = request.getParameter("catName");
        String catDesc = request.getParameter("catDesc");

        request.setAttribute("catName",catName);
        request.setAttribute("catDesc",catDesc);

        String vMsg = "";
        if (SysFun.isNullOrEmpty(catName)){
            vMsg += "类目名不能为空。";
        }
        if (SysFun.isNullOrEmpty(catDesc)){
            vMsg += "说明不能为空。";
        }
        NewsCat newsCat = newsCatService.loadByName(catName);
        if (newsCat != null){
            vMsg += "该类目已存在。";
        }
        if (!SysFun.isNullOrEmpty(vMsg)){
            request.setAttribute("msg",vMsg);
            System.out.println(vMsg);
            return mView;
        }

        NewsCat bean = new NewsCat();
        bean.setCatName(catName);
        bean.setCatDesc(catDesc);
        bean.setParentId(0L);
        bean.setSortNum(0L);
        Date date = new Date();
        bean.setCreateOn(date);
        bean.setUpdateOn(date);
        Long result = 0L;
        try {
            result = newsCatService.insert(bean);
        }catch (Exception e){
            vMsg += "添加失败，原因："+e.getMessage();
        }
        if (result > 0){
            mView.setViewName(getDispatcherPath("Go","preload"));
            return mView;
        }else {
            request.setAttribute("msg",vMsg);
            return mView;
        }
    }

    @Override
    @RequestMapping(BEAN_PREFIX+"update")
    protected ModelAndView updateView(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat","update");
        HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();
        String vId = request.getParameter("id");
        if (!SysFun.isNullOrEmpty(vId)){
            Long iId = SysFun.parseLong(vId);
            NewsCat bean = newsCatService.load(iId);
            if (bean != null){
                request.setAttribute("catId",bean.getCatId());
                request.setAttribute("catName",bean.getCatName());
                request.setAttribute("catDesc",bean.getCatDesc());

                return mView;
            }
        }
        mView.setViewName(getDispatcherPath("Go","preload"));
        return mView;
    }

    @Override
    @RequestMapping(BEAN_PREFIX+"updateDeal")
    protected ModelAndView updateDeal(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat","update");
        HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();
        String catId = request.getParameter("catId");
        String catName = request.getParameter("catName");
        String catDesc = request.getParameter("catDesc");
        request.setAttribute("catId",catId);
        request.setAttribute("catName",catName);
        request.setAttribute("catDesc",catDesc);

        String vMsg = "";
        if (SysFun.isNullOrEmpty(catId)){
            vMsg += "主键不能为空。";
        }
        if (SysFun.isNullOrEmpty(catName)){
            vMsg += "类目名称不能为空。";
        }
        if (SysFun.isNullOrEmpty(catDesc)){
            vMsg += "类目说明不能为空。";
        }
        if (!SysFun.isNullOrEmpty(vMsg)){
            request.setAttribute("msg",vMsg);
            System.out.println(vMsg);
            return mView;
        }

        /**
         * 数据库验证
         * */
        Long iId = SysFun.parseLong(catId);
        NewsCat bean = newsCatService.load(iId);
        if (bean == null){
            vMsg += "记录不存在";
        }
        /**
         * 如果验证失败则将失败内容放到作用域变量返回，并转发页面
         */
        if (!SysFun.isNullOrEmpty(vMsg)){
            request.setAttribute("msg",vMsg);
            System.out.println(vMsg);
            return mView;
        }
        /**
         * 真正处理
         */
        bean.setCatName(catName);
        if (SysFun.isNullOrEmpty(catDesc)){
            /*密码为空，说明不需要更改密码*/
        }else {
            bean.setCatDesc(catDesc);
        }
        Date date = new Date();
        bean.setUpdateOn(date);
        Long result = 0L;
        try {
            result = newsCatService.update(bean);
        } catch (Exception e) {
            vMsg += "修改失败，原因："+e.getMessage();
        }
        if (result>0){
            mView.setViewName(getDispatcherPath("Go","preload"));
            return mView;
        }else {
            request.setAttribute("msg",vMsg);
            return mView;
        }
    }

    @Override
    @RequestMapping(BEAN_PREFIX+"detail")
    protected ModelAndView detailView(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat","detail");
        HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();
        String vId = request.getParameter("id");
        if (!SysFun.isNullOrEmpty(vId)){
            Long iId = SysFun.parseLong(vId);
            NewsCat bean = newsCatService.load(iId);
            if (bean != null){
                request.setAttribute("bean",bean);
                return mView;
            }
        }
        mView.setViewName(getDispatcherPath("Go","preload"));
        return mView;
    }

    @Override
    protected ModelAndView detailDeal(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    protected ModelAndView deleteView(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    @RequestMapping(BEAN_PREFIX+"deleteDeal")
    protected ModelAndView deleteDeal(HttpServletRequest request, HttpServletResponse response) {
        handleBase(request,response);
        ModelAndView mView = getMView("NewsCat","delete");
        /**
         * 获取主键，再根据主键获取记录
         */
        String vId = request.getParameter("id");

        if (!SysFun.isNullOrEmpty(vId)){
            Long iId = SysFun.parseLong(vId);
            Long result = newsCatService.delete(iId);
            if (result > 0){
                mView.setViewName(getDispatcherPath("Go","ok"));
                return mView;
            }
        }
        mView.setViewName(getDispatcherPath("Go","no"));
        return mView;
    }
}

package edu.springboot.sbmuc.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

/**
 * @author Yelf
 * @create 2022-11-23-9:57
 */
@Controller
public class MyUserCenterController {

    @Autowired
    private MyUserCenterService myUserCenterService;

    @GetMapping("/register")
    @ResponseBody
    public String register() throws Exception {
        Long startTime = System.currentTimeMillis();
        myUserCenterService.insertUser();
        Future<Integer> email = myUserCenterService.sendEmail();
        Future<Integer> sms = myUserCenterService.sendSms();
        int total = email.get() + sms.get();
        System.out.println("异步任务数据统计汇总结果： " + total);

        Long endTime = System.currentTimeMillis();
        System.out.println("总共耗时："+(endTime-startTime));
        return "success";
    }
}

package edu.springboot.sbmuc.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

@Controller
public class MyAsyncController {
    @Autowired
    private MyAsyncService myService;

    @GetMapping("/sendSMS")
    @ResponseBody
    public String sendSMS() throws Exception {
        System.out.println("主流程开始...");
        System.out.println("主线程，当前线程ID为：" + Thread.currentThread().getId());
        Long startTime = System.currentTimeMillis();
        myService.sendSMS();
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程完成，耗时： " + (endTime - startTime));
        return "success";
    }

    @GetMapping("/statistics")
    @ResponseBody
    public String statistics() throws Exception {
        System.out.println("主流程开始...");
        System.out.println("主线程，当前线程ID为：" + Thread.currentThread().getId());
        Long startTime = System.currentTimeMillis();
        Future<Integer> futureA = myService.processA();
        Future<Integer> futureB = myService.processB();
        int total = futureA.get() + futureB.get();
        System.out.println("异步任务数据统计汇总结果： " + total);
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程完成，耗时： " + (endTime - startTime));
        return "success";
    }
}

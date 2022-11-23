package edu.springboot.sbmuc.service2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Yelf
 * @create 2022-11-23-9:57
 */
@Service
public class MyUserCenterService {

    public Future<Integer> insertUser() throws Exception {
        System.out.println("主线程业务insertUser开始...");
        System.out.println("主线程，当前线程ID为：" + Thread.currentThread().getId());
        Long startTime = System.currentTimeMillis();
        Thread.sleep(10);
        int count=123456;
        Long endTime = System.currentTimeMillis();
        System.out.println("主线程业务insertUser完成，耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }
    @Async
    public Future<Integer> sendEmail() throws Exception {
        System.out.println("业务sendEmail开始...");
        System.out.println("sendEmail，当前线程ID为：" + Thread.currentThread().getId());
        Long startTime = System.currentTimeMillis();
        Thread.sleep(20);
        int count=654321;
        Long endTime = System.currentTimeMillis();
        System.out.println("业务sendEmail完成，耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }
    @Async
    public Future<Integer> sendSms() throws Exception {
        System.out.println("业务sendSms开始...");
        Long startTime = System.currentTimeMillis();
        System.out.println("sendSms，当前线程ID为：" + Thread.currentThread().getId());
        Thread.sleep(30);
        int count=654321;
        Long endTime = System.currentTimeMillis();
        System.out.println("业务sendSms完成，耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }

}

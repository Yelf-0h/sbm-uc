package edu.springboot.sbmuc.service2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * 异步服务
 *
 * @author Yefl
 * @date 2022/11/23
 */
@Service
public class MyAsyncService {
    @Async
    public void sendSMS() throws Exception {
        System.out.println("短信业务开始...");
        System.out.println("短信线程，当前线程ID为：" + Thread.currentThread().getId());
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("短信业务完成，耗时：" + (endTime - startTime));
    }

    @Async
    public Future<Integer> processA() throws Exception {
        System.out.println("业务A开始...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(4000);
        int count=123456; // 业务A要返回的数据
        Long endTime = System.currentTimeMillis();
        System.out.println("业务A完成，耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }
    @Async
    public Future<Integer> processB() throws Exception {
        System.out.println("业务B开始...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        int count=654321; // 业务B要返回的数据
        Long endTime = System.currentTimeMillis();
        System.out.println("业务B完成，耗时：" + (endTime - startTime));
        return new AsyncResult<Integer>(count);
    }

}

package edu.springboot.sbmuc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 主应用
 *
 * @author Yefl
 * @date 2022/10/12
 */
@SpringBootApplication
@MapperScan("edu.springboot.sbmuc.mapper")
@EnableAsync
public class SbmUcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbmUcApplication.class, args);
    }

}

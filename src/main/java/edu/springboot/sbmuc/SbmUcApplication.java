package edu.springboot.sbmuc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主应用
 *
 * @author Yefl
 * @date 2022/10/12
 */
@SpringBootApplication
@MapperScan("edu.springboot.sbmuc.mapper")
public class SbmUcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbmUcApplication.class, args);
    }

}

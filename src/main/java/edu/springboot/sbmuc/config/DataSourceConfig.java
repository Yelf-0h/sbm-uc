package edu.springboot.sbmuc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Yelf
 * @create 2022-09-07-8:39
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource DruidDataSource(){
        DataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}

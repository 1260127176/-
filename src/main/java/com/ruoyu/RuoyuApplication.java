package com.ruoyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.ruoyu.mapper")
public class RuoyuApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoyuApplication.class, args);
    }

}

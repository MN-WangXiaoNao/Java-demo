package com.wzg.mbsb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangzhigang
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wzg.mbsb.mapper"})
public class MybatisSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringbootDemoApplication.class, args);
    }

}

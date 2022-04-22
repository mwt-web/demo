package com.mwt.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author muwentao
 * exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
 */
@SpringBootApplication()
@MapperScan("com.mwt.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

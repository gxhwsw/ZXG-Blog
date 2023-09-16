package com.zxg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gxhhhh
 * @create 2023/9/15 18:17
 */
@SpringBootApplication
@MapperScan("com.zxg.mapper")
public class ZXGBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZXGBlogApplication.class,args);
    }
}

package com.xjt.movie;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@MapperScan("com.xjt.movie.mapper")
@EnableTransactionManagement
@Slf4j
@SpringBootApplication
public class XiongMovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiongMovieApplication.class, args);

        log.warn("后台server测试接口：http://localhost:8880");
        log.warn("后台管理界面接口：http://localhost:8881");
        log.warn("前台展示界面接口：http://localhost:8882");
    }
}

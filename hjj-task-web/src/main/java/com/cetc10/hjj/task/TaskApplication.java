package com.cetc10.hjj.task;

import cn.jasonone.ueditor.EnableUeditor;
import com.cetc10.hjj.task.enable.EnableAgent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@EnableAgent
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.cetc10.hjj.task.mapper")
@EnableUeditor
public class TaskApplication {
    static {
        //Spring Boot集成Druid出现异常报错的原因及解决
        System.setProperty("druid.mysql.usePingMethod","false");
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

}

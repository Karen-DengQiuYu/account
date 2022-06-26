package com.cetc10.hjj.task;



import com.cetc10.hjj.task.enable.EnableAgent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAgent
public class TestApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(TestApplication.class,args);
    }
}

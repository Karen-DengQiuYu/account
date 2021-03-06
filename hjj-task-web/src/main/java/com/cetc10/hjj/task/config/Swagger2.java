package com.cetc10.hjj.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*http://localhost:8090/swagger-ui.html 这是调试的访问路径*/
@Configuration
@EnableSwagger2
public class Swagger2 {
  @Bean
     public Docket createRestApi() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .apiInfo(apiInfo())
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.cetc10.hjj.task.controller"))
                 .paths(PathSelectors.any())
                 .build();
     }
     private ApiInfo apiInfo() {
         return new ApiInfoBuilder()
                 .title("Spring Boot中使用Swagger2构建RESTful APIs")
                 .description("仅用于开发环境")
                 .termsOfServiceUrl("")
                 .contact("walle")
                 .version("1.0")
                 .build();
     }

}

package com.progra3.estudiantes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EstudiantesDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudiantesDbApplication.class, args);
	}
	 @Bean
     public Docket api() {
         return new Docket(DocumentationType.SWAGGER_2)
                 .select()
                 .apis(RequestHandlerSelectors.basePackage("com.progra3.estudiantes"))
                 .build()
                 .apiInfo(apiDetails());
                 
     }
	 private ApiInfo apiDetails() {
         return new ApiInfoBuilder()
                 .title("api estudiantes")
                 .contact(new Contact("Charles","no-url", "myemail"))
                 .description("Muestra api SPRINGBOOT")
                 .build();
     }

	
}

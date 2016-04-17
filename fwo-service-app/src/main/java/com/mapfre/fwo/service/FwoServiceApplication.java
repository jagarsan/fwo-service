package com.mapfre.fwo.service;


import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan
public class FwoServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(FwoServiceApplication.class, args);
	}

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fwo-service")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/(shared|gaia)/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("FWO REST Service API Sample")
                .description("Operation Framework REST Service API Sample")
                .contact("pda@efronconsulting.com")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
	
}

package com.mapfre.fwo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration and ui application
 * @author jagarcia
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	/**
	 * @return fwo-service for docket configuration
	 */
    @Bean
    public Docket fwoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("fwo-service")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @return the metadata for the API
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("FWO REST Service API Sample")
                .description("Operation Framework REST Service API Sample")
                .contact("pda@efronconsulting.com")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}

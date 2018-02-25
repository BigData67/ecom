package com.formation.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean 
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.formation.api"))
          .paths(PathSelectors.any())                         
          .build()
          .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
    	return new ApiInfo(
    	"ECOM Application",
    	"Api pour Ecom-catalogs",
    	"API Categories-Products",
    	"Terms of service",
    	new Contact("MM", "www.formation.com", "formation167@gmail.com"),
    	"License Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
   }
}

package org.serratec.backend.h2banco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	//métodos de configuração
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				//.apis(RequestHandlerSelectors.basePackage("org.serratec.java2backend.h2banco.controller"))
				.paths(PathSelectors.any())
				.build(); 
		
	
	}

}
//http://localhost:8080/swagger-ui/index.html

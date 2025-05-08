package com.dev.sp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry reg) {
		reg.addMapping("/**")
		.allowedOrigins("http://localhost")
		.allowedMethods("*")
		.allowedHeaders("*");
	}

}

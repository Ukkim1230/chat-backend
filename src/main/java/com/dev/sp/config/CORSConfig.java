package com.dev.sp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dev.sp.interceptor.AuthInterceptor;
import com.dev.sp.util.FileUploadUtil;

@Configuration
public class CORSConfig implements WebMvcConfigurer{
	@Autowired
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addCorsMappings(CorsRegistry reg) {
		reg.addMapping("/**")
		.allowedOrigins("http://localhost:3000")
		.allowedMethods("*") // GET, POST, PUT, DELETE, OPTIONS
		.allowedHeaders("*");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) { //http 통신만 intercept 함
		reg.addResourceHandler("/file/**")
		.addResourceLocations("file:////" + FileUploadUtil.ROOT)
		.setCachePeriod(36000)
		.resourceChain(true);
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry reg) {
		reg.addInterceptor(authInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/users/join","/users/login","/file/**","/error","/boards/**","/boards2/**");
	}
	
}
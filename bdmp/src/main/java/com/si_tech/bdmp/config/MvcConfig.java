package com.si_tech.bdmp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig {
      @Bean
      public WebMvcConfigurer webMvcConfigurer() {
    	  return new WebMvcConfigurer() {
    		@Override
    		public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/test/");
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    		}
		};
      }
}

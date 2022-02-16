package com.cesur.gestionpracticas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EntityScan(basePackages = "com.cesur.gestionpracticas.models")
public class GestionpracticasApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(GestionpracticasApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/styles/**")) {
            registry.addResourceHandler("/styles/**").addResourceLocations("classpath:/styles/");
        }
        
        if(!registry.hasMappingForPattern("/img/**")) {
            registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
        }
    }

}

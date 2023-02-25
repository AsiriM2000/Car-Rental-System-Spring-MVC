package lk.ijse.carrental.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.carrental.advice.AppWideExceptionHandler;
import lk.ijse.carrental.controller.CustomerController;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackageClasses = {CustomerController.class,AppWideExceptionHandler.class})
@EnableWebMvc
public class WebAppConfig{

}

package lk.ijse.carrental.config;

import lk.ijse.carrental.advice.AppWideExceptionHandler;
import lk.ijse.carrental.controller.CustomerController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = {CustomerController.class,AppWideExceptionHandler.class})
@EnableWebMvc
public class WebAppConfig {

}

package com.cdc.framework.config;

import org.h2.server.web.JakartaWebServlet; // or org.h2.server.web.WebServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<JakartaWebServlet> h2Servlet() {
        System.out.println("h2 console is registered");

        ServletRegistrationBean<JakartaWebServlet> registration
                = new ServletRegistrationBean<>(
                new JakartaWebServlet(), "/h2-console/*");

        registration.setLoadOnStartup(1);
        return registration;
    }
}
package com.soa12.assignment10.web;

import com.soa12.assignment10.controller.AuthController;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.xml.ws.Endpoint;

@Configuration
public class WebConfig {
//    @Resource
    private AuthController authController=new AuthController();

//    private AuthController authController=new AuthController().getAuthController();

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean(name = "authEndpoint")
    public Endpoint endpoint1() {
//        authController=new AuthController();
        EndpointImpl endpoint = new EndpointImpl(springBus(), authController);
        endpoint.publish("/auth");
        return endpoint;
    }

}

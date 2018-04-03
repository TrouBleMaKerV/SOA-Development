package com.soa12.assignment10.web;

import com.soa12.assignment10.controller.AuthController;
import com.soa12.assignment10.controller.ScoreManageController;
import com.soa12.assignment10.controller.UserManageController;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebConfig {

    private AuthController authController=new AuthController();
    private UserManageController userManageController = new UserManageController();
    private ScoreManageController scoreManageController = new ScoreManageController();

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soa12/*");
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean(name = "authEndpoint")
    public Endpoint endpoint1() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), authController);
        endpoint.publish("/auth");
        return endpoint;
    }
    @Bean(name = "userManageEndpoint")
    public Endpoint endpoint2() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), userManageController);
        endpoint.publish("/userManage");
        return endpoint;
    }
    @Bean(name = "scoreManageEndpoint")
    public Endpoint endpoint3() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), scoreManageController);
        endpoint.publish("/scoreManage");
        return endpoint;
    }
}

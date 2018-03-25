package com.soa12.assignment10.web;

import com.soa12.assignment10.controller.AuthController;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class WebConfig {
    @Resource
    private AuthController authController;

}

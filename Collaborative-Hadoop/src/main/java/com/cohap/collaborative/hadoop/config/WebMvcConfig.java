/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cohap.collaborative.hadoop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 *
 * @author Haseeb Khizar
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry r){
        
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer config){
        config.enable();
    }
    
    
}

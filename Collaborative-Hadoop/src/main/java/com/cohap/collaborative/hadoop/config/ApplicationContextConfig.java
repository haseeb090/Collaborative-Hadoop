/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cohap.collaborative.hadoop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 *
 * @author Haseeb Khizar
 */

@Configuration
@ComponentScan("com.cohap.collaborative.hadoop.*")
public class ApplicationContextConfig {
    
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewR = new InternalResourceViewResolver();
        viewR.setPrefix("/WEB-INF/pages/");
        viewR.setSuffix(".jsp");
        
        return viewR;
    }
    
    @Bean(name="multipartResolver")
    public MultipartResolver getMultipartResolver(){
        CommonsMultipartResolver r = new CommonsMultipartResolver();
        //100MB limit
        r.setMaxUploadSize(100 * 1024 * 1024);
        return r;
    }
    
}

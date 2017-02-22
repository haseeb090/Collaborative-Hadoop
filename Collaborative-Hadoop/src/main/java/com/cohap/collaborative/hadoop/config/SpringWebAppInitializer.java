/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cohap.collaborative.hadoop.config;

import javax.servlet.FilterRegistration;
import javax.servlet.*;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
/**
 *
 * @author Haseeb Khizar
 */
public class SpringWebAppInitializer implements WebApplicationInitializer{
    
    @Override
    public void onStartup(ServletContext sC) throws ServletException{
        AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
        app.register(ApplicationContextConfig.class);
        
        ServletRegistration.Dynamic dispatch = sC.addServlet("SpringDispatcher", new DispatcherServlet(app));
        dispatch.setLoadOnStartup(1);
        dispatch.addMapping("/");
        
        //Character filter
        FilterRegistration.Dynamic fR = sC.addFilter("encodingFiler", CharacterEncodingFilter.class);
        
        fR.setInitParameter("encoding", "UTF-8");
        fR.setInitParameter("forceEncoding", "true");
        fR.addMappingForUrlPatterns(null, true, "/*");
    }
    
}

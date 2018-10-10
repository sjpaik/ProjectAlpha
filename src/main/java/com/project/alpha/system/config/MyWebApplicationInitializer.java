package com.project.alpha.system.config;

import com.project.alpha.system.filter.CustomRequestLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebApplicationInitializer.class);

    @Override
    public void onStartup(@NonNull ServletContext servletContext) {

        LOGGER.debug("# My WebApplicationInitializer Start");

        // Spring Basic ContextLoaderListener 설정
        XmlWebApplicationContext basicContext = new XmlWebApplicationContext();
        basicContext.setConfigLocation("classpath*:spring/context-import.xml");
        basicContext.refresh();
        basicContext.start();

        servletContext.addListener(new ContextLoaderListener(basicContext));

        // Spring ServletContextListener 설정
        XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
        dispatcherContext.setConfigLocation("/WEB-INF/config/dispatcher-servlet.xml");
        ServletRegistration.Dynamic spring = servletContext.addServlet("spring", new DispatcherServlet(dispatcherContext));
        spring.setLoadOnStartup(1);
        spring.addMapping("/");

        // Spring CharacterEncodingFilter 설정
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        // Spring CommonsRequestLoggingFilter 설정
        servletContext.addFilter("loggingFilter", CustomRequestLoggingFilter.class)
                .addMappingForServletNames(null, false, "spring");

        // Spring Security Filter 설정
        FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
        springSecurityFilterChain.addMappingForUrlPatterns(null, true, "/*");

        // Spring RequestContextListener 설정
        servletContext.addListener(new RequestContextListener());

    }
}

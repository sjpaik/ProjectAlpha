package com.project.alpha.system.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebApplicationInitializer.class);

    @Override
    public void onStartup(@NonNull ServletContext servletContext) {

        LOGGER.debug("# My WebApplicationInitializer Start");

        // Spring CharacterEncodingFilter 설정
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        // Spring CommonsRequestLoggingFilter 설정
        FilterRegistration.Dynamic loggingFilter = servletContext.addFilter("loggingFilter", new CommonsRequestLoggingFilter());
        loggingFilter.setInitParameter("includeClientInfo", "true");
        loggingFilter.setInitParameter("includeHeaders", "true");
        loggingFilter.setInitParameter("includePayload", "true");
        loggingFilter.setInitParameter("includeQueryString", "true");
        loggingFilter.setInitParameter("maxPayloadLength", "1000");
        loggingFilter.addMappingForUrlPatterns(null, true, "/*");

        // Spring RequestContextListener 설정
        servletContext.addListener(new RequestContextListener());

        LOGGER.debug("# My WebApplicationInitializer End");

    }
}

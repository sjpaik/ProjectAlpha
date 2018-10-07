package com.project.alpha.system.config;

import com.project.alpha.system.filter.CustomRequestLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;

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
        servletContext.addFilter("loggingFilter", CustomRequestLoggingFilter.class)
                .addMappingForServletNames(null, false, "spring");

        // Spring RequestContextListener 설정
        servletContext.addListener(new RequestContextListener());

        LOGGER.debug("# My WebApplicationInitializer End");

    }
}

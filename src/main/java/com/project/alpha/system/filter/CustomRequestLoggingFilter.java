package com.project.alpha.system.filter;

import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class CustomRequestLoggingFilter extends CommonsRequestLoggingFilter {

    public CustomRequestLoggingFilter() {
        super.setIncludeHeaders(true);
        super.setIncludeClientInfo(true);
        super.setIncludeQueryString(true);
        super.setIncludePayload(true);
        super.setMaxPayloadLength(1000);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) { }

}

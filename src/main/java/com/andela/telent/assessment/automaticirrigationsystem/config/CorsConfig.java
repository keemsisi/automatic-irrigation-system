package com.andela.telent.assessment.automaticirrigationsystem.config;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain
    ) throws IOException, ServletException {

        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                "Authorization, Content-Type, xsrf-token," +
                        "content-length, X-Requested-With, X-Auth-Token"
        );
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "xsrf-token, X-Auth-Token");
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, httpServletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

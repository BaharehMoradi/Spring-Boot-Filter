package com.example.springbootfilter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

//@Component
//@Order(3)
public class RequestResponseLoggingFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        logger.info(
                "RequestResponseLoggingFilter: Logging Request in RequestResponseLoggingFilter class  {} : {}", req.getMethod(),
                req.getRequestURI());

        chain.doFilter(request, response);

        logger.info(
                "RequestResponseLoggingFilter: Logging Response in RequestResponseLoggingFilter class {}", res.getContentType());
    }
}
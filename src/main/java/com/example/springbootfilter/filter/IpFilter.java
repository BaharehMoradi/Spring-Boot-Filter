package com.example.springbootfilter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Order(3)
public class IpFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        logger.info(
                "Order(3): Logging Request in IpFilter class  {} : {}", req.getMethod(),
                req.getRequestURI());

        chain.doFilter(request, response);

        logger.info(
                "Order(3): Logging Response in IpFilter class {} :", res.getContentType());
    }
}


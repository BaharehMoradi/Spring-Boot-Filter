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
@Order(1)
public class TransactionFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);


    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        logger.info(
                "Order(1): Starting a transaction for req in TransactionFilter class : {}", req.getRequestURI());

        chain.doFilter(request, response);

        logger.info(
                "Order(1): Committing a transaction for req in TransactionFilter class: {}",res.getContentType());
    }
}
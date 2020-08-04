package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class MyFilter  implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest servletRequest=(HttpServletRequest) request;
            System.out.println("My filter"+((HttpServletRequest) request).getRequestURI());
            filterChain.doFilter(request,response);
        }

        @Override
        public void destroy() {

        }
    }


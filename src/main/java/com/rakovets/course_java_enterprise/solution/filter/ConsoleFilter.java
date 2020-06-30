package com.rakovets.course_java_enterprise.solution.filter;


import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class ConsoleFilter implements Filter {


        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("LogFilter init!");
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            Map<String, String[]> parameters = servletRequest.getParameterMap();
            parameters.forEach((name, strings) -> System.out.println("Имя параметра: " + name + " Значение параметра " + strings[0]));
            String servletPath = req.getServletPath();
            System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath //
                    + ", URL =" + req.getRequestURL());
            filterChain.doFilter(servletRequest, servletResponse);
        }

        @Override
        public void destroy() {

        }
    }


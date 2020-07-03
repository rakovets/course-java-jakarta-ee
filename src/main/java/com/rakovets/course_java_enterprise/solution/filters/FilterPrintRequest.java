package com.rakovets.course_java_enterprise.solution.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(servletNames = "myFilter", urlPatterns = "*")
public class FilterPrintRequest implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Enumeration enumeration = servletRequest.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = (String) enumeration.nextElement();
            System.out.println(parameterName + " : " + servletRequest.getParameter(parameterName));
        }
    }
}

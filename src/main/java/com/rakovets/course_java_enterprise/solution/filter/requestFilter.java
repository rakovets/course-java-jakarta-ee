package com.rakovets.course_java_enterprise.solution.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("*")
public class requestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = servletRequest.getRemoteAddr();
        String serverName = servletRequest.getServerName();

        System.out.printf("REQUEST....\n%s\n%s", ipAddress, serverName);
    }
}

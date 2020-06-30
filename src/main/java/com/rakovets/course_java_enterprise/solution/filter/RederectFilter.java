package com.rakovets.course_java_enterprise.solution.filter;

import javax.servlet.*;
import java.io.IOException;

public class RederectFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getRequestDispatcher("/jsp/safe.jsp").forward(servletRequest, servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

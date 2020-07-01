package com.rakovets.course_java_enterprise.solution.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "RederectFilter", urlPatterns = "/unsafe")
public class RederectFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getRequestDispatcher("/WEB-INF/jsp/safe.jsp").forward(servletRequest, servletResponse);
    }
}

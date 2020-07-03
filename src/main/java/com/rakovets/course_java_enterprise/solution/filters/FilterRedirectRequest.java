package com.rakovets.course_java_enterprise.solution.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "myFilter", urlPatterns = "/unsafe")
public class FilterRedirectRequest implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getRequestDispatcher("/WEB-INF/jsp/safe.jsp").forward(servletRequest,servletResponse);
    }
}

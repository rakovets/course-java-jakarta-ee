package com.rakovets.course_java_enterprise.solution.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(servletNames = "UnsafeServlet", urlPatterns = {"/unsafe"})
public class SafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = "/WEB-INF/jsp/safe.jsp";
        servletRequest.getRequestDispatcher(path).forward(servletRequest, servletResponse);
    }
}

package com.rakovets.course_java_enterprise.solution.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/authentication")
public class AuthenticationFilter implements Filter {
    private String name = "admin";
    private String password = "Qwweerr";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String pathSuccess = "/WEB-INF/jsp/authentication-admin.jsp";
        String pathNotSuccess = "/WEB-INF/jsp/authentication-user.jsp";
        if (servletRequest.getParameter("name").equals(name) && servletRequest.getParameter("password").equals(password)) {
            servletRequest.getRequestDispatcher(pathSuccess).forward(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher(pathNotSuccess).forward(servletRequest, servletResponse);
        }
    }
}

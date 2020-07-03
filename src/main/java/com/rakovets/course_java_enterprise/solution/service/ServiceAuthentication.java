package com.rakovets.course_java_enterprise.solution.service;

public class ServiceAuthentication {
    private static ServiceAuthentication INSTANCE = null;

    private ServiceAuthentication() {
    }

    public static ServiceAuthentication getInstance() {
        if (INSTANCE == null) {
            synchronized (ServiceAuthentication.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ServiceAuthentication();
                }
            }
        }
        return INSTANCE;
    }

    public boolean checkNameAndPassword(String login, String password) {
        boolean check = false;
        if (login.equals("admin") & password.equals("1234")) {
            check = true;
        }
        return check;
    }
}

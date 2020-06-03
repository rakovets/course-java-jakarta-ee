package main.java.com.rakovets.course_java_enterprise.solution.entity;

import main.java.com.rakovets.course_java_enterprise.solution.connection.ConnectionMeneger;

public class ConnectionExemples {

    public static void main(String[] args) {
        ConnectionMeneger connectionMeneger = new ConnectionMeneger();
        connectionMeneger.createConnection();
    }
}

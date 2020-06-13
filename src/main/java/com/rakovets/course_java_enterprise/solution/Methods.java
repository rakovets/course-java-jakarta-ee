package main.java.com.rakovets.course_java_enterprise.solution;

import java.util.Scanner;

public class Methods {
    Scanner scanner = new Scanner(System.in);

    public String askName() {
        System.out.println("Введите ваше Имя:");
        String name = scanner.nextLine();
        return name;
    }

    public String askSurname() {
        System.out.println("Введите вашу Фамилию:");
        String surname = scanner.nextLine();
        return surname;
    }

}

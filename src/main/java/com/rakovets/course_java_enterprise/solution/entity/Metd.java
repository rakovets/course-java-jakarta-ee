package main.java.com.rakovets.course_java_enterprise.solution.entity;

import java.util.Scanner;

public class Metd {

    Scanner scanner = new Scanner(System.in);

    public Integer askRestaurantId() {
        System.out.println("К какому ресторану вы хотите добавить свой отзыв ?");
        Integer rewie = scanner.nextInt();
        return rewie;
    }
    public String askContent(){
        System.out.println("Введите отзыв который хотите добавить: ");
        String content = scanner.nextLine();
        return content;
    }

}

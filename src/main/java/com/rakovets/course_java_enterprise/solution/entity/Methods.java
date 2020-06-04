package main.java.com.rakovets.course_java_enterprise.solution.entity;

import java.util.Scanner;

public class Methods {

    Scanner scanner = new Scanner(System.in);

    private Integer askRestaurantId() {
        System.out.println("К какому ресторану вы хотите добавить отзыв ?");
        Integer rewie = scanner.nextInt();
        return rewie;
    }
}

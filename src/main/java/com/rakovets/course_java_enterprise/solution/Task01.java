package com.rakovets.course_java_enterprise.solution;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Locale localeUs = Locale.US;
        Locale localeRu = new Locale("ru", "RU");
        Locale localeBy = new Locale("by", "BY");
        ResourceBundle resourceBundleUs = ResourceBundle.getBundle("translations", localeUs);
        ResourceBundle resourceBundleRu = ResourceBundle.getBundle("translations", localeRu);
        ResourceBundle resourceBundleBy = ResourceBundle.getBundle("translations", localeBy);
        String textUs = resourceBundleUs.getString("text");
        String textRu = resourceBundleRu.getString("text");
        String textBy = resourceBundleBy.getString("text");

        Scanner scannerLine = new Scanner(System.in);
        System.out.print("Enter value (en, ru, by): ");
        String value =  scannerLine.nextLine();
        if(value.equals("en")){
            System.out.println(textUs);
        } else if(value.equals("ru")) {
            System.out.println(textRu);
        } else if(value.equals("by")) {
            System.out.println(textBy);
        } else {
            System.out.println("Entered value is false");
        }
    }
}

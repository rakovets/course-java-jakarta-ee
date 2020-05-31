package main.java.com.rakovets.course_java_enterprise.solution.jdbc.controllers;

import main.java.com.rakovets.course_java_enterprise.solution.jdbc.models.RequestToDB;
import main.java.com.rakovets.course_java_enterprise.solution.jdbc.view.Print;
import java.util.Scanner;

public class Controller {
	Scanner scanner = new Scanner(System.in);
	public int command;

	public void musicStoreRunController() {
		System.out.println("\nDB \"MUSIC STORE\"");
		boolean runMain = true;
		while (runMain) {
			new Print().printActionOptionsUI();
			System.out.print("> ");
			command = scanner.nextInt();
			switch (command) {
				case 1:
					System.out.println("All artists: ");
					new RequestToDB().returnAllArtists();
					break;
				default:
					System.out.println("COMMAND NUMBER NOT EXIST");
			}
		}
	}
}
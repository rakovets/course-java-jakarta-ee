package main.java.com.rakovets.course_java_enterprise.solution.jdbc.controllers;

import main.java.com.rakovets.course_java_enterprise.solution.jdbc.models.RequestToDB;
import main.java.com.rakovets.course_java_enterprise.solution.jdbc.view.Print;
import java.util.Scanner;

public class Controller {
	Scanner scanner = new Scanner(System.in);

	public void musicStoreRunController() {
		System.out.println("\nDB \"MUSIC STORE\"");
		boolean runMain = true;
		while (runMain) {
			new Print().printActionOptionsUI();
			System.out.print("> ");
			int command = scanner.nextInt();
			switch (command) {
				case 1:
					System.out.println("All artists: ");
					new RequestToDB().returnAllArtists();
					break;
				case 2:
				System.out.println("All songs: ");
				new RequestToDB().returnAllSongs();
				break;
				case 3:
					System.out.print("Enter artist Id : ");
					int id = scanner.nextInt();
					new RequestToDB().returnArtistById(id);
					break;
				default:
					System.out.println("COMMAND NUMBER NOT EXIST");
			}
		}
	}
}
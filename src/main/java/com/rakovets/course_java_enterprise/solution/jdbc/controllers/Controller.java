package main.java.com.rakovets.course_java_enterprise.solution.jdbc.controllers;

import main.java.com.rakovets.course_java_enterprise.solution.jdbc.models.RequestToDB;
import main.java.com.rakovets.course_java_enterprise.solution.jdbc.view.Print;
import java.util.Scanner;

public class Controller {
	Scanner scannerInt = new Scanner(System.in);
	Scanner scannerLine = new Scanner(System.in);

	public void musicStoreRunController() {
		System.out.println("\nDB \"MUSIC STORE\"");
		boolean runMain = true;
		while (runMain) {
			new Print().printActionOptionsUI();
			System.out.print("> ");
			int command = scannerInt.nextInt();
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
					int idArtist = scannerInt.nextInt();
					new RequestToDB().returnArtistById(idArtist);
					break;
				case 4:
					System.out.print("Enter song Id : ");
					int idSong = scannerInt.nextInt();
					new RequestToDB().returnSongById(idSong);
					break;
				case 5:
					System.out.print("Enter new artist: ");
					String newArtist = scannerLine.nextLine();
					new RequestToDB().createNewArtist(newArtist);
					break;
				case 6:
					System.out.print("Enter new song: ");
					String newSong = scannerLine.nextLine();
					System.out.print("Enter length song: ");
					int length = scannerInt.nextInt();
					System.out.print("Enter artist Id: ");
					int idArtistForSong = scannerInt.nextInt();
					new RequestToDB().createNewSong(newSong, length, idArtistForSong);
					break;
				default:
					System.out.println("COMMAND NUMBER NOT EXIST");
			}
		}
	}
}
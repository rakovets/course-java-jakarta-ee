package main.java.com.rakovets.course_java_enterprise.solution.jdbc.database;

public class Song {
	private int idSong;
	private String nameSong;
	private int length;

	public Song(int idSong, String nameSong, int length) {
		this.idSong = idSong;
		this.nameSong = nameSong;
		this.length = length;
	}

	public int getIdSong() {
		return idSong;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}

	public String getNameSong() {
		return nameSong;
	}

	public void setNameSong(String nameSong) {
		this.nameSong = nameSong;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "database.Song{" +
				"idSong=" + idSong +
				", nameSong='" + nameSong + '\'' +
				", length=" + length +
				'}';
	}
}
package main.java.com.rakovets.course_java_enterprise.solution.jdbc.database;

public class Artist {
	private int idArtist;
	private String nameArtist;

	public Artist(int id, String nameArtist) {
		this.idArtist = id;
		this.nameArtist = nameArtist;
	}

	public int getIdArtist() {
		return idArtist;
	}

	public void setIdArtist(int idArtist) {
		this.idArtist = idArtist;
	}

	public String getNameArtist() {
		return nameArtist;
	}

	public void setNameArtist(String nameArtist) {
		this.nameArtist = nameArtist;
	}

	@Override
	public String toString() {
		return "database.Artist{" +
				"id=" + idArtist +
				", nameArtist='" + nameArtist + '\'' +
				'}';
	}
}
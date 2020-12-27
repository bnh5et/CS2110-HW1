/*
 * Briana Hart
 * HW 1
 * Lab 103
 */

/**
 * This class represents a Song that can be played. Songs can be added to PlayLists.
 * @author Briana Hart bnh5et
 *
 */
public class Song implements Comparable<Song> {

	private String artist;
	private String title;
	private int minutes;
	private int seconds;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/**
	 * Makes a new Song object.
	 * 
	 * @param artist
	 * @param title
	 * 
	 */
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}

	/**
	 * Makes a new Song object.
	 * 
	 * @param artist
	 * @param title
	 * @param minutes
	 * @param seconds
	 */
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * Makes a new Song object equal to the Song that is in the parameter.
	 * 
	 * @param s
	 */
	public Song(Song s) {
		this.artist = s.getArtist();
		this.title = s.getTitle();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();

	}

	/**
	 * Returns true only if a Song's artist, title, minutes, and seconds are
	 * equal to those of Object o.
	 */
	public boolean equals(Object o) {
		boolean result = false;
		if (this == o) return true;
		if (o instanceof Song) {
			Song other = (Song) o;
			result = getTitle() == other.getTitle()
					&& getArtist() == other.getArtist()
					&& getMinutes() == other.getMinutes()
					&& getSeconds() == other.getSeconds();
		}
		return result;
	}

	@Override
	public String toString() {
		return "{Song: title=" + title + " artist=" + artist + "}";
	}

	/**
	 * Prints out the artist and title of a Song that is being played.
	 */
	public void play() {
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist,
				title);
	}

	@Override
	public int compareTo(Song o) {
		int result = artist.compareTo(o.artist);
		if (result == 0) {
			result = title.compareTo(o.title);
			if (result == 0) {
				if (minutes > o.minutes) {
					return 1;
				}
				else if (minutes < o.minutes) {
					return -1;
				}
				else if (minutes == o.minutes) {
					if (seconds > o.seconds) {
						return 1;
					}
					else if (seconds > o.seconds) {
						return -1;
					}
					else return 0;
				}
			}
		}
		return result;
	}

}

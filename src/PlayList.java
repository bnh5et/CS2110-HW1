/*
 * Briana Hart
 * HW 1
 * Lab 103
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class represents a PlayList, which is a list of songs. Multiple songs
 * can be added to PlayLists.
 * 
 * @author Briana Hart bnh5et
 * 
 * 
 */
public class PlayList {

	private String name;
	private ArrayList<Song> songList = new ArrayList<Song>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}

	@Override
	public String toString() {
		return "The PlayList " + name + " contains the songs " + songList;
	}

	/**
	 * Creates a new PlayList object with the name "Untitled".
	 */
	public PlayList() {
		this.name = "Untitled";
	}

	/**
	 * Creates a new PlayList object.
	 * 
	 * @param newName
	 */
	public PlayList(String newName) {
		this.name = newName;
	}

	/**
	 * Loads songs from the file that is in the parameter and adds them to a
	 * PlayList. Returns true if any songs are added.
	 * 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public boolean loadSongs(String fileName) {
		boolean result = false;
		File newFile = new File(fileName);
		Scanner reader = null;
		try {
			reader = new Scanner(newFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (reader.hasNextLine()) {
			String title = reader.nextLine();
			title = title.trim();
			String artist = reader.nextLine();
			artist = artist.trim();
			String time = reader.nextLine();
			String[] timeSplit = time.split(":");
			int min = Integer.parseInt(timeSplit[0]);
			int sec = Integer.parseInt(timeSplit[1]);
			if (sec > 60) {
				int totalMin = sec / 60;
				String tString = totalMin + "";
				String[] tSplit = tString.split(".");
				min += Integer.parseInt(tSplit[0]);
				sec = Integer.parseInt(tSplit[1]) * 60;
			}
			Song ns = new Song(artist, title, min, sec);
			songList.add(ns);
			result = true;
			reader.nextLine();
		}
		reader.close();
		return result;
	}

	/**
	 * Returns true if all the songs on a PlayList are removed.
	 * 
	 * @return
	 */
	public boolean clear() {
		boolean result = false;
		if (songList.size() > 0) {
			songList.removeAll(this.songList);
			return true;
		}
		return result;
	}

	/**
	 * Returns true if the song in the parameter is added to a PlayList and
	 * returns false if it is not.
	 * 
	 * @param s
	 * @return
	 */
	public boolean addSong(Song s) {
		int check1 = 0;
		if (songList.size() > 0) {
			check1 = songList.size();
		}
		songList.add(s);
		int check2 = songList.size();
		return check1 + 1 == check2;

	}

	/**
	 * Removes the Song at the index and returns the Song.
	 * 
	 * @param index
	 * @return
	 */
	public Song removeSong(int index) {
		if (index >= songList.size() || index < 0) {
			return null;
		}
		return songList.remove(index);
	}

	/**
	 * Removes every occurrence of Song s from the PlayList and returns the
	 * song.
	 * 
	 * @param s
	 * @return
	 */
	public Song removeSong(Song s) {
		for (int i = 0; i < songList.size(); i++) {
			if (songList.get(i).equals(s)) {
				songList.remove(s);
			}
		}
		return s;
	}

	/**
	 * Returns the song at the index in the parameter.
	 * 
	 * @param index
	 * @return
	 */
	public Song getSong(int index) {
		if (index >= songList.size() || index < 0) {
			return null;
		}
		if (songList.size() > 0) {
			Song s = songList.get(index);
			return s;
		}
		return null;
	}

	/**
	 * Sorts the SongList by artist, then by title, and then by time.
	 */
	public void sortByArtist() {
		Collections.sort(songList);
	}

	/**
	 * Play every song in a PlayList.
	 */
	public void play() {
		for (int i = 0; i < songList.size(); i++) {
			songList.get(i).play();
		}
	}

	/**
	 * Returns the size of a PlayList.
	 * 
	 * @return
	 */
	public int size() {
		int size = songList.size();
		return size;
	}

	/**
	 * Returns the total time that a PlayList will take in the format HH:MM:SS.
	 * 
	 * @return
	 */
	public String totalPlayTime() {
		int min = 0;
		int sec = 0;
		for (int i = 0; i < songList.size(); i++) {
			min += songList.get(i).getMinutes();
			sec += songList.get(i).getSeconds();
		}
		int total = (min * 60) + sec;
		int hr = total / 3600;
		total = total % 3600;
		min = total / 60;
		total = total % 60;
		sec = total;
		if (hr > 0) {
			return hr + ":" + min + ":" + sec;
		}
		else return min + ":" + sec;
		
	}

	/**
	 * Returns the time that a PlayList will take in seconds.
	 * 
	 * @return
	 */
	public int getPlayTimeSeconds() {
		int min = 0;
		int sec = 0;
		for (int i = 0; i < songList.size(); i++) {
			min += songList.get(i).getMinutes();
			sec += songList.get(i).getSeconds();
		}
		return (min * 60) + sec;
	}

//	public static void main(String[] args) {
//		Song s1 = new Song("Bob Dylan", "Hurricane", 3, 42);
//		Song s2 = new Song("","", 53,56);
//		Song s3 = new Song("Taylor Swift", "Red", 4, 20);
//		
//		PlayList pl = new PlayList();
//		pl.addSong(s2);
//		pl.addSong(s3);
//		pl.addSong(s1);
//
//		System.out.println(pl.size());
//		System.out.println(pl);
//		System.out.println(pl.getPlayTimeSeconds());
//		System.out.println(pl.totalPlayTime());
//		pl.sortByArtist();
//		System.out.println(pl);
//		
//		System.out.println(pl.getSong(3));
//		
//		
//	}
}

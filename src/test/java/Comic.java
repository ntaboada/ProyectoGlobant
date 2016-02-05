package com.globant.training.glb_training.controller;

public class Comic implements Comparable<Comic> {
	private String name;
	private String genre;
	private int volume;
	private int copies;

	public Comic(String name, String genre, int volume) {
		this.name = name;
		this.genre = genre;
		this.volume = volume;
		this.copies = 1;
	}

	public Comic(String name, String genre, int volume, int copies) {
		this.name = name;
		this.genre = genre;
		this.volume = volume;
		this.copies = copies;
	}

	public String toStringBasic() {
		return "[" + name + "] [" + volume + "] [" + genre + "]";
	}

	public String toString() {
		return "[" + name + "] [" + volume + "] [" + genre + "] [" + copies + "]";
	}

	public String getName() {
		return this.name;
	}

	public String getGenre() {
		return this.genre;
	}

	public int getVolume() {
		return this.volume;
	}

	public void increaseCopies() {
		this.copies += 1;
	}

	public boolean decreaseCopies() {
		if (copies >= 1) {
			this.copies -= 1;
			return true;
		}
		return false;
	}

	public int getCopies() {
		return copies;
	}

	public boolean equals(Comic c) {
		if (this.compareTo(c) == 0)
			return true;
		return false;
	}

	@Override
	public int compareTo(Comic arg0) {
		return (this.getName() + this.getVolume()).compareTo(arg0.getName() + arg0.getVolume());
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setVolume(int volume){
		this.volume = volume;
	}

}

package com.films4you.req4;

import java.time.LocalDate;

/**
 * This class represents a Film in the Films4You system.
 */
public class Film {

  
  private String title;

private LocalDate releaseYear;
private int filmId;
private String description;

  public Film(int filmId, String title) {
	   if (filmId < 0) {
		      throw new IllegalArgumentException("filmId must be greater than or equal to 0");
		    }
	this.filmId = filmId;
  
    this.title = title;

  }

  public int getFilmId() {
	    return this.filmId;
	}

  public String getTitle() {
    return title;
  }





public LocalDate getReleaseYear() {
	return releaseYear;
}

public void setReleaseYear(LocalDate releaseYear) {
	this.releaseYear = releaseYear;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Category getCategoryId() {
	// TODO Auto-generated method stub
	return null;
}


}
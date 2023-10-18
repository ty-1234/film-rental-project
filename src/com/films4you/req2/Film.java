package com.films4you.req2;

import java.time.LocalDate;

/**

This class represents a Film with its attributes such as filmId, title, releaseYear and description.
*/
public class Film {
private String title; // The title of the film
private LocalDate releaseYear; // The release year of the film
private int filmId; // The ID of the film


/**

Constructs a Film object with a specified filmId and title.
@param filmId the ID of the film, must be greater than or equal to 0
@param title the title of the film
@throws IllegalArgumentException if the specified filmId is negative
*/
public Film(int filmId, String title) {
if (filmId < 0) {
throw new IllegalArgumentException("filmId must be greater than or equal to 0");
}
this.filmId = filmId;
this.title = title;
}
/**

Returns the ID of the film.
@return the ID of the film
*/
public int getFilmId() {
return this.filmId;
}
/**

Returns the title of the film.
@return the title of the film
*/
public String getTitle() {
return title;
}
/**

Returns the release year of the film.
@return the release year of the film
*/
public LocalDate getReleaseYear() {
return releaseYear;
}
/**

Sets the release year of the film.
@param releaseYear the release year of the film
*/
public void setReleaseYear(LocalDate releaseYear) {
this.releaseYear = releaseYear;
}

}
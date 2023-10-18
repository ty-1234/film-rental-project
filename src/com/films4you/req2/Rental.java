package com.films4you.req2;

import java.time.LocalDateTime;

import org.checkerframework.checker.nullness.qual.Nullable;



/**

This class represents a Rental with its attributes such as rentalId, rentalDate, film.
*/
public class Rental {
private int rentalId = 0; // The ID of the rental
private LocalDateTime rentalDate; // The date when the rental was made
private Film film; // The film associated with this rental


/**

Constructs a Rental object with a specified rentalId and inventoryID.
@param rentalId the ID of the rental, must be greater than or equal to 0
@param inventoryID the ID of the inventory associated with this rental
@throws IllegalArgumentException if the specified rentalId is negative
*/
public Rental(int rentalId, int inventoryID) {
if (rentalId < 0) {
throw new IllegalArgumentException("rentalId must be greater than or equal to 0");
}
this.rentalId = rentalId;
}
/**

Returns the ID of the rental.
@return the ID of the rental
*/
public int getRentalId() {
return rentalId;
}
/**

Returns the date when the rental was made.
@return the date when the rental was made
*/
public LocalDateTime getRentalDate() {
return rentalDate;
}
/**

Returns the film associated with this rental.
@return the film associated with this rental
*/
public Film getFilm() {
return film;
}
/**

Sets the film associated with this rental.
@param film the film associated with this rental
*/
public void setFilm(@Nullable Film film) {
this.film = film;
}





}
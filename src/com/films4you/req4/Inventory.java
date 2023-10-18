package com.films4you.req4;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int inventoryId;
    private Film film;
    private List<Rental> rentals = new ArrayList<>();
    

    public Inventory(int inventoryId, Film film) {
        this.inventoryId = inventoryId;
        this.film = film;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public Film getFilm() {
        return film;
    }
    
    public String getFilmTitle() {
        return film.getTitle();
    }

	public int getFilmId() {

		return 	film.getFilmId();
	}
	public void addRental(Rental rental) {
        // set the rental's film to this inventory's film
        rental.setFilm(film);

        // add the rental to the inventory's rentals
        rentals.add(rental);
    }
}
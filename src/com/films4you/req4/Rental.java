package com.films4you.req4;

import org.checkerframework.checker.nullness.qual.Nullable;



public class Rental {
    private int rentalId=0;
    private Film film;
    private int rentalCount = 0;
    private int inventoryID;

    public Rental(int rentalId, int inventoryID) {
    	   if (rentalId < 0) {
    		      throw new IllegalArgumentException("rentalId must be greater than or equal to 0");
    		    }
        this.rentalId = rentalId;
      
       

    }

    public int getRentalId() {
        return rentalId;
    }


    public Film getFilm() {
        return film;
    }
    public void setFilm(@Nullable Film film) {
        this.film = film;
      }
    public void addRental() {
        rentalCount++;
      }

	public int getRentalCount() {
		return rentalCount;
	}

	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}

	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}


}
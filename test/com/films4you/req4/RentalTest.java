package com.films4you.req4;
import org.junit.Test;
import static org.junit.Assert.*;

public class RentalTest {

    @Test
    public void testConstructorWithValidRentalId() {
        int rentalId = 1;
        int inventoryID = 2;
        Rental rental = new Rental(rentalId, inventoryID);
        assertEquals(rentalId, rental.getRentalId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidRentalId() {
        int rentalId = -1;
        int inventoryID = 2;
        new Rental(rentalId, inventoryID);
    }

    @Test
    public void testSetAndGetFilm() {
        Rental rental = new Rental(1, 2);
        Film film = new Film(120, "Film Title");
        rental.setFilm(film);
        assertEquals(film, rental.getFilm());
    }

    @Test
    public void testAddAndGetRentalCount() {
        Rental rental = new Rental(1, 2);
        rental.addRental();
        assertEquals(1, rental.getRentalCount());
    }

    @Test
    public void testSetAndGetInventoryId() {
        Rental rental = new Rental(1, 2);
        rental.setInventoryID(3);
        assertEquals(3, rental.getInventoryID());
    }
}
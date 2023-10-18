package com.films4you.req2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class RentalTest {

    private Rental rental;

    @Before
    public void setUp() {
        rental = new Rental(1, 2);
    }

    @Test
    public void testGetRentalId() {
        assertEquals(1, rental.getRentalId());
    }

    @Test
    public void testGetRentalDate() {
        assertNull(rental.getRentalDate());
    }

    @Test
    public void testGetFilm() {
        assertNull(rental.getFilm());
    }

    @Test
    public void testSetFilm() {
        Film film = new Film(1972,  "The Godfather");
        rental.setFilm(film);
        assertEquals(film, rental.getFilm());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeRentalId() {
        Rental rental = new Rental(-1, 2);
    }
}
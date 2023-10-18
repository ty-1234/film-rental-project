package com.films4you.req2;

import org.junit.Test;
import static org.junit.Assert.*;

public class FilmTest {

    @Test
    public void testGetFilmId() {
        Film film = new Film(1, "The Shawshank Redemption");
        assertEquals(1, film.getFilmId());
    }

    @Test
    public void testGetTitle() {
        Film film = new Film(1, "The Shawshank Redemption");
        assertEquals("The Shawshank Redemption", film.getTitle());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNegativeFilmId() {
        Film film = new Film(-1, "The Godfather");
    }

}
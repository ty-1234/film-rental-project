package com.films4you.req2;

import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void testGetInventoryId() {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(1);
        assertEquals(1, inventory.getInventoryId());
    }

    @Test
    public void testGetFilmID() {
        Inventory inventory = new Inventory();
        inventory.setFilmID(2);
        assertEquals(2, inventory.getFilmID());
    }

    @Test
    public void testSetInventoryId() {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(3);
        assertEquals(3, inventory.getInventoryId());
    }

    @Test
    public void testSetFilmID() {
        Inventory inventory = new Inventory();
        inventory.setFilmID(4);
        assertEquals(4, inventory.getFilmID());
    }
}
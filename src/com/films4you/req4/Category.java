package com.films4you.req4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Category {
    private int categoryId;
    private String name;
    private List<Inventory> inventories;
    private List<Rental> rentals;

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
        this.inventories = new ArrayList<>();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }


    public List<Inventory> getInventories() {
        return inventories;
    }
    public void addFilm(Film film) {
        // check if the film already exists in the category
        for (Inventory inventory : inventories) {
            if (inventory.getFilmId() == film.getFilmId()) {
                return; // the film already exists, so we don't need to add it again
            }
        }
        
        // create a new inventory for the film
        Inventory newInventory = new Inventory(inventories.size(), film);
        inventories.add(newInventory);
    }
    public void addInventory(Inventory inventory) {
        // check if the inventory already exists in the category
        for (Inventory existingInventory : inventories) {
            if (existingInventory.getInventoryId() == inventory.getInventoryId()) {
                return; // the inventory already exists, so we don't need to add another one
            }
        }

        // add the new inventory to the list
        inventories.add(inventory);
    }
    
    public void addRental(int inventoryId, Rental rental) {
        // check if the inventory exists in the category
        Inventory inventory = null;
        for (Inventory inv : inventories) {
            if (inv.getInventoryId() == inventoryId) {
                inventory = inv;
                break;
            }
        }
        if (inventory == null) {
            return; // the inventory doesn't exist, so we can't add a rental
        }
        
        // set the film in the rental to the film in the inventory
        rental.setFilm(inventory.getFilm());
        
        // set the rental's inventory ID to the inventory's ID
        rental.setInventoryID(inventory.getInventoryId());
        
        // add the rental to the category
        rentals.add(rental);
        
        // increment the rental count for the inventory
        inventory.addRental(rental);;
    }

}

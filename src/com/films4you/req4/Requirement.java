package com.films4you.req4;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;
import com.films4you.main.TaskNotAttemptedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Your class description here.

 * @author Your name
 *
 */
public class Requirement implements RequirementInterface {
	 private final Database db;

	    /**
	     * Creates a new Requirement object.
	     *
	     * @param db The Database object to use for executing queries.
	     */
	    public Requirement(Database db) {
	        this.db = db;
	    }
	    public List<Category> getCategories(Database db) throws SQLException {
	        List<Category> categories = new ArrayList<>();

	        // Retrieve all categories
	        ResultSet categoryRs = db.query("SELECT * FROM category");
	        while (categoryRs.next()) {
	            int categoryId = categoryRs.getInt("category_id");
	            String categoryName = categoryRs.getString("name");

	            // Create a new Category object and add it to the categories list
	            Category newCategory = new Category(categoryId, categoryName);
	            categories.add(newCategory);

	            // Retrieve all film_category rows for this category
	            ResultSet filmCategoryRs = db.query("SELECT * FROM film_category");
	            while (filmCategoryRs.next()) {
	                int currentCategoryId = filmCategoryRs.getInt("category_id");
	                if (currentCategoryId == categoryId) {
	                    int currentFilmId = filmCategoryRs.getInt("film_id");

	                    // Retrieve all film rows for this film id
	                    ResultSet filmRs = db.query("SELECT * FROM film");
	                    while (filmRs.next()) {
	                        int filmId = filmRs.getInt("film_id");
	                        if (filmId == currentFilmId) {
	                            String title = filmRs.getString("title");
	                            Film film = new Film(filmId, title);
	                            newCategory.addFilm(film);

	                            // Retrieve all inventory rows for this film
	                            ResultSet inventoryRs = db.query("SELECT * FROM inventory");
	                            while (inventoryRs.next()) {
	                                int inventoryFilmId = inventoryRs.getInt("film_id");
	                                if (inventoryFilmId == filmId) {
	                                    int inventoryId = inventoryRs.getInt("inventory_id");
	                                    Inventory inventory = new Inventory(inventoryId, film);
	                                    newCategory.addInventory(inventory);

	                                    // Retrieve all rental rows for this inventory item
	                                    ResultSet rentalRs = db.query("SELECT * FROM rental");
	                                    while (rentalRs.next()) {
	                                        int rentalInventoryId = rentalRs.getInt("inventory_id");
	                                        if (rentalInventoryId == inventoryId) {
	                                            int rentalId = rentalRs.getInt("rental_id");
	                                            Rental rental = new Rental(rentalId, rentalInventoryId);
	                                            inventory.addRental(rental);
	                                        }
	                                    }
	                                    rentalRs.close();
	                                }
	                            }
	                            inventoryRs.close();
	                        }
	                    }
	                    filmRs.close();
	                }
	            }
	            filmCategoryRs.close();
	        }
	        categoryRs.close();

	        return categories;
	    }
	    

	    @Override
	    public String getValueAsString() {
	        try {
	            // Get the list of categories with their most popular films
	            List<Category> categories = getCategories(db);

	            // Create a StringBuilder to construct the result string
	            StringBuilder resultBuilder = new StringBuilder();
	            resultBuilder.append("Top popular films in each category:\n");

	            // Iterate over the categories and add their most popular films to the result string
	            for (Category category : categories) {
	                resultBuilder.append(category.getName()).append(": ");
	                List<Inventory> inventories = category.getInventories();
	                if (!inventories.isEmpty()) {
	                    Inventory inventory = inventories.get(0);
	                    Film film = new Film(inventory.getFilmId(), inventory.getFilmTitle());
	                    resultBuilder.append(film.getTitle());
	                } else {
	                    resultBuilder.append("No films found in this category");
	                }
	                resultBuilder.append("\n");
	            }

	            return resultBuilder.toString();
	        } catch (SQLException e) {
	            // Handle any SQL exceptions
	            e.printStackTrace();
	            return "";
	        }
	    }



	                    
	    @Override
	    public @NonNull String getHumanReadable() {
	      try {
	        List<Category> categories = getCategories(db);

	        StringBuilder resultBuilder = new StringBuilder();
	        resultBuilder.append("Top popular films in each category:\n");

	        for (Category category : categories) {
	          resultBuilder.append("Category: ").append(category.getName()).append("\n");

	          List<Inventory> inventories = category.getInventories();
	          if (inventories.isEmpty()) {
	            resultBuilder.append("- No films found in this category\n");
	          } else {
	            for (int i = 0; i < Math.min(3, inventories.size()); i++) {
	              Inventory inventory = inventories.get(i);
	              resultBuilder.append("- ").append(inventory.getFilmTitle()).append("\n");
	            }
	          }

	          resultBuilder.append("\n");
	        }

	        return resultBuilder.toString();
	      } catch (SQLException e) {
	        e.printStackTrace();
	        return "";
	      }
	    }

  }



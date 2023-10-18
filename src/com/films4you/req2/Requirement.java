package com.films4you.req2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;

/**
 * Implements the RequirementInterface to get the top 10 most popular films based on the number of rentals.
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

    /**
     * Returns the top 10 films by rental count as a CSV string.
     *
     * @return The top 10 films by rental count as a CSV string.
     */
   
    private List<Rental> getRentals(Database db) throws SQLException {
        List<Rental> rentals = new ArrayList<>();
        Map<Integer, Film> films = new HashMap<>();
        Map<Integer, Inventory> inventory = new HashMap<>();

        // Retrieve all films and add them to the film map
        ResultSet filmRs = db.query("SELECT * FROM film");
        while (filmRs.next()) {
            Film newFilm = new Film(filmRs.getInt("film_id"), filmRs.getString("title"));
            films.put(newFilm.getFilmId(), newFilm);
        }

        // Retrieve all inventory and add them to the inventory map
        ResultSet inventoryRs = db.query("SELECT * FROM inventory");
        while (inventoryRs.next()) {
            Inventory newInventory = new Inventory();
            newInventory.setInventoryId(inventoryRs.getInt("inventory_id"));
            newInventory.setFilmID(inventoryRs.getInt("film_id"));
            inventory.put(newInventory.getInventoryId(), newInventory);
        }

        // Retrieve all rentals
        ResultSet rentalRs = db.query("SELECT * FROM rental");
        while (rentalRs.next()) {
            int rentalId = rentalRs.getInt("rental_id");
            int inventoryId = rentalRs.getInt("inventory_id");

            // Retrieve the film and inventory for the rental
            Film film = films.get(inventory.get(inventoryId).getFilmID());
            Inventory rentalInventory = inventory.get(inventoryId);

            // Create a new Rental object and add it to the rentals list
            Rental newRental = new Rental(rentalId, rentalInventory.getInventoryId());
            newRental.setFilm(film);
            rentals.add(newRental);
        }

        return rentals;
    }
    
    public String getValueAsString() {
        try {
            List<Rental> rentals = getRentals(this.db); // pass the current Database object
            Map<Film, Integer> filmRentalCounts = new HashMap<>();

            // Count the number of rentals for each film.
            for (Rental rental : rentals) {
                Film film = rental.getFilm();
                filmRentalCounts.put(film, filmRentalCounts.getOrDefault(film, 0) + 1);
            }

            // Sort the films by rental count, breaking ties by title and release date.
            List<Film> sortedFilms = new ArrayList<>(filmRentalCounts.keySet());
            sortedFilms.sort((f1, f2) -> {
                int rentalCountComparison = Integer.compare(filmRentalCounts.get(f2), filmRentalCounts.get(f1));
                if (rentalCountComparison != 0) {
                    return rentalCountComparison;
                }
                int titleComparison = f1.getTitle().compareTo(f2.getTitle());
                if (titleComparison != 0) {
                    return titleComparison;
                }
                return f1.getReleaseYear().compareTo(f2.getReleaseYear());
            });

            // Get the top 10 films.
            List<Film> top10Films = sortedFilms.subList(0, Math.min(10, sortedFilms.size()));

            // Build the CSV string.
            StringBuilder sb = new StringBuilder();
            for (Film film : top10Films) {
                sb.append(film.getFilmId()).append(",").append(film.getTitle()).append(",").append(filmRentalCounts.get(film)).append("\n");
            }

            return sb.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }





    @Override
    public String getHumanReadable() {
        try {
            List<Rental> rentals = getRentals(db);
            Map<Film, Integer> filmRentalCounts = new HashMap<>();

            // Count the number of rentals for each film.
            for (Rental rental : rentals) {
                Film film = rental.getFilm();
                filmRentalCounts.put(film, filmRentalCounts.getOrDefault(film, 0) + 1);
            }

            // Sort the films by rental count, breaking ties by title and release date.
            List<Film> sortedFilms = new ArrayList<>(filmRentalCounts.keySet());
            sortedFilms.sort((f1, f2) -> {
                int rentalCountComparison = Integer.compare(filmRentalCounts.get(f2), filmRentalCounts.get(f1));
                if (rentalCountComparison != 0) {
                    return rentalCountComparison;
                }
                int titleComparison = f1.getTitle().compareTo(f2.getTitle());
                if (titleComparison != 0) {
                    return titleComparison;
                }
                return f1.getReleaseYear().compareTo(f2.getReleaseYear());
            });

            // Get the top 10 films.
            List<Film> top10Films = sortedFilms.subList(0, Math.min(10, sortedFilms.size()));

            // Build the human-readable string.
            StringBuilder sb = new StringBuilder();
            sb.append("Top 10 most popular films based on the number of rentals:\n\n");
            sb.append(String.format("%-5s %-40s %s\n", "ID", "Title", "Rental count"));
            sb.append(String.format("%-5s %-40s %s\n", "--", "-----", "------------"));
            for (Film film : top10Films) {
                sb.append(String.format("%-5d %-40s %d\n", film.getFilmId(), film.getTitle(), filmRentalCounts.get(film)));
            }

            return sb.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
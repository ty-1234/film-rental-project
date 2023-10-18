package com.films4you.req1;
import java.sql.SQLException;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import com.films4you.main.RequirementInterface;

/**
 * A requirement to get the total number of actors in the database.
 * User story: AS A casting director at Films4You, I NEED TO know
 * the total number of actors in the database SO THAT I can plan
 * casting for upcoming productions.
 *
 * Assumes there is an "actor" table in the database with columns "actor_id", "first_name", and "last_name".
 * This class assumes that the Actor class has been updated to match these assumptions.
 */
public class Requirement implements RequirementInterface {

    /**
     * Get the total number of actors in the database.
     *
     * @return Total number of actors.
     * @throws SQLException          on database error.
     * @throws IllegalStateException on error, e.g. value null when not allowed.
     */
    int getNumberOfActors() throws SQLException, IllegalStateException {
        Actor[] actors = Actor.getAllActors();
        return actors.length;
    }

    /**
     * A method to return the total number of actors in the database.
     *
     * @return The total number of actors in the database.
     */
    @Override
    public @Nullable String getValueAsString() {
        try {
            return Integer.toString(getNumberOfActors());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * A method to get and parse the non-human-readable string
     * from getValueAsString and return it in human-readable format.
     *
     * @return A string formatted for the end user containing the total number
     * of actors in the database. In the format "There are [COUNT] actors in the database."
     */
    @Override
    public @NonNull String getHumanReadable() {
        String value = getValueAsString();
        if (value == null) {
            return "Sorry, no results found or error occurred.";
        }

        return "There are " + value + " actors in the database.";
    }
}


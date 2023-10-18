package com.films4you.req1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.films4you.main.Database;

/**
 * Represents an actor in a film.
 */
public class Actor {
  private final int actor_id;
  private final String first_name;
  private final String last_name;
  private final Timestamp last_update;

  /**
   * Constructor for an Actor object.
   *
   * @param actor_id The ID of the actor.
   * @param first_name The first name of the actor.
   * @param last_name The last name of the actor.
   * @param last_update The timestamp of the last update to the actor's record.
   */
  public Actor(int actor_id, String first_name, String last_name, Timestamp last_update) {
	  if (actor_id < 0) {
	      throw new IllegalArgumentException("actorID must be greater than or equal to 0");
	    }
    this.actor_id = actor_id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.last_update = last_update;
  }

  /**
   * Get the ID of the actor.
   *
   * @return The ID of the actor.
   */
  public int getActorId() {
    return actor_id;
  }

  /**
   * Get the first name of the actor.
   *
   * @return The first name of the actor.
   */
  public String getFirstName() {
    return first_name;
  }

  /**
   * Get the last name of the actor.
   *
   * @return The last name of the actor.
   */
  public String getLastName() {
    return last_name;
  }

  /**
   * Get the timestamp of the last update to the actor's record.
   *
   * @return The timestamp of the last update to the actor's record.
   */
  public Timestamp getLastUpdate() {
    return last_update;
  }

  /**
   * Retrieve all actors from the database.
   *
   * @return An array of Actor objects representing all actors in the database.
   */
  public static Actor[] getAllActors() {
	    String query = "SELECT * FROM actor";
	    Database db = new Database();
	    ResultSet rs = db.query(query);

	    if (rs == null) {
	      return new Actor[0];
	    }

	    Actor[] actors = extractActorsFromResultSet(rs);

	    db.close();
	    return actors;
	  }

	  /**
	   * Extract an array of Actor objects from a ResultSet.
	   *
	   * @param rs The ResultSet containing actor data.
	   * @return An array of Actor objects extracted from the ResultSet.
	   */
	  private static Actor[] extractActorsFromResultSet(ResultSet rs) {
	    try {
	      List<Actor> actorsList = new ArrayList<>();
	      while (rs.next()) {
	        int actor_id = rs.getInt("actor_id");
	        String first_name = rs.getString("first_name");
	        String last_name = rs.getString("last_name");
	        Timestamp last_update = rs.getTimestamp("last_update");

	        Actor actor = new Actor(actor_id, first_name, last_name, last_update);
	        actorsList.add(actor);
	      }

	      return actorsList.toArray(new Actor[actorsList.size()]);
	    } catch (SQLException e) {
	      System.err.println(e);
	      return new Actor[0];
	    }
	  }
}
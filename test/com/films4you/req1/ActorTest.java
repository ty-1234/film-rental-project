package com.films4you.req1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Test;

public class ActorTest {

  @Test
  public void testConstructor() {
    int actor_id = 1;
    String first_name = "John";
    String last_name = "Doe";
    Timestamp last_update = new Timestamp(System.currentTimeMillis());

    Actor actor = new Actor(actor_id, first_name, last_name, last_update);

    assertEquals(actor_id, actor.getActorId());
    assertEquals(first_name, actor.getFirstName());
    assertEquals(last_name, actor.getLastName());
    assertEquals(last_update, actor.getLastUpdate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNegativeActorId() {
    new Actor(-1, "John", "Doe", new Timestamp(System.currentTimeMillis()));
  }

  @Test
  public void testGetAllActors() {
    Actor[] actors = Actor.getAllActors();

    assertNotNull(actors);
    assertTrue(actors.length > 0);
  }

}
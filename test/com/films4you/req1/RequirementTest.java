package com.films4you.req1;

import org.junit.Test;
import static org.junit.Assert.*;

public class RequirementTest {

    @Test
    public void testGetNumberOfActors() throws Exception {
        Requirement requirement = new Requirement();
        int numActors = requirement.getNumberOfActors();
        assertTrue(numActors >= 0);
    }

    @Test
    public void testGetValueAsString() throws Exception {
        Requirement requirement = new Requirement();
        String value = requirement.getValueAsString();
        assertNotNull(value);
        assertTrue(value.matches("\\d+"));
    }

    @Test
    public void testGetHumanReadable() throws Exception {
        Requirement requirement = new Requirement();
        String humanReadable = requirement.getHumanReadable();
        assertNotNull(humanReadable);
        assertTrue(humanReadable.matches("There are \\d+ actors in the database\\."));
    }
}

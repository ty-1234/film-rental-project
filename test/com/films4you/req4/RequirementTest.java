package com.films4you.req4;

import java.sql.SQLException;
import org.junit.Test;
import com.films4you.main.Database;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

public class RequirementTest {
    private Database db;
    private Requirement requirement;

    @Before
    public void setUp() throws Exception {
        // Set up the Database and Requirement objects for testing
        db = new Database(); // Replace with your own Database implementation
        requirement = new Requirement(db);
    }

    @Test
    public void testGetCategories() throws SQLException {
        // Test that getCategories returns a non-empty list of categories
        assertEquals(true, !requirement.getCategories(db).isEmpty());
    }

    @Test
    public void testGetValueAsString() {
        // Test that getValueAsString returns a non-empty string
        assertEquals(true, !requirement.getValueAsString().isEmpty());
    }

    @Test
    public void testGetHumanReadable() {
        // Test that getHumanReadable returns a non-empty string
        assertEquals(true, !requirement.getHumanReadable().isEmpty());
    }
}
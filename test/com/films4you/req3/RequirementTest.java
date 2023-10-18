package com.films4you.req3;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RequirementTest {

    private Requirement requirement;

    @Before
    public void setUp() throws Exception {
        requirement = new Requirement();
    }

    @After
    public void tearDown() throws Exception {
        // clean up any resources used by the requirement
    }

    @Test
    public void testGetValueAsString() throws SQLException {
        String expected = "1,PENELOPE,GUINESS\n54,PENELOPE,PINKETT\n104,PENELOPE,CRONYN\n120,PENELOPE,MONROE\n";
        assertEquals(expected, requirement.getValueAsString());
    }

    @Test
    public void testGetHumanReadable() {
        String expected = "Actors with first name PENELOPE:\n1. GUINESS, PENELOPE\n2. PINKETT, PENELOPE\n3. CRONYN, PENELOPE\n4. MONROE, PENELOPE\n";
        assertEquals(expected, requirement.getHumanReadable());
    }

}
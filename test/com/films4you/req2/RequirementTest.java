package com.films4you.req2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.films4you.main.Database;

public class RequirementTest {
    private Database db;
    private Requirement req;
    
    private final String EXPECTED_OUTPUT = "Top 10 most popular films based on the number of rentals:\n\n" +
            "ID    Title                                    Rental count\n" +
            "--    -----                                    ------------\n" +
            "103   BUCKET BROTHERHOOD                       34\n" +
            "738   ROCKETEER MOTHER                         33\n" +
            "331   FORWARD TEMPLE                           32\n" +
            "382   GRIT CLOCKWORK                           32\n" +
            "489   JUGGLER HARDLY                           32\n" +
            "730   RIDGEMONT SUBMARINE                      32\n" +
            "767   SCALAWAG DUCK                            32\n" +
            "31    APACHE DIVINE                            31\n" +
            "369   GOODFELLAS SALUTE                        31\n" +
            "418   HOBBIT ALIEN                             31\n";

    @Before
    public void setUp() throws Exception {
        // Set up the Database and Requirement objects
        db = new Database();
        req = new Requirement(db);
    }

    @Test
    public void testGetHumanReadable() {
        // Ensure that the actual output matches the expected output
        assertEquals(EXPECTED_OUTPUT, req.getHumanReadable());
    }
 
}
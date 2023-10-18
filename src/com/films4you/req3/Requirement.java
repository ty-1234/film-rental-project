package com.films4you.req3;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**

Represents a requirement to find all actors with the first name "PENELOPE" in the testing database.
*/
public class Requirement implements RequirementInterface {

// The SQL query to execute on the database
private static final String SQL_QUERY = "SELECT * FROM actor;";

// The database connection
private Database db = new Database();

/**
* Returns a string representation of the actors with the first name "PENELOPE".
* @return A string representation of the actors with the first name "PENELOPE".
*/
@Override
public @Nullable String getValueAsString() {
StringBuilder result = new StringBuilder();
try {
ResultSet rs = db.query(SQL_QUERY);
while (rs.next()) {
String first_name = rs.getString("first_name");
if (first_name.equalsIgnoreCase("PENELOPE")) {
int actor_id = rs.getInt("actor_id");
String last_name = rs.getString("last_name");
result.append(actor_id).append(",").append(first_name).append(",").append(last_name).append("\n");
}
}
rs.close();
} catch (SQLException e) {
e.printStackTrace();
}
db.close();
return result.toString();
}

/**
* Returns a human-readable string representation of the actors with the first name "PENELOPE".
* @return A human-readable string representation of the actors with the first name "PENELOPE".
*/
@Override
public @NonNull String getHumanReadable() {
StringBuilder result = new StringBuilder("Actors with first name PENELOPE:\n");
try {
ResultSet rs = db.query(SQL_QUERY);
int count = 0;
while (rs.next()) {
String first_name = rs.getString("first_name");
if (first_name.equalsIgnoreCase("PENELOPE")) {
count++;
String last_name = rs.getString("last_name");
result.append(count).append(". ").append(last_name).append(", ").append(first_name).append("\n");
}
}
rs.close();
if (count == 0) {
result.append("None found.");
}
} catch (SQLException e) {
e.printStackTrace();
}
db.close();
return result.toString();
}
}
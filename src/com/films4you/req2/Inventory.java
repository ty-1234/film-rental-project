package com.films4you.req2;

/**

This class represents an Inventory item with its attributes such as inventoryId and filmID.
*/
public class Inventory {
private int inventoryId; // The ID of the inventory
private int filmID; // The ID of the film associated with this inventory

/**

Returns the ID of the inventory.
@return the ID of the inventory
*/
public int getInventoryId() {
return inventoryId;
}
/**

Sets the ID of the inventory.
@param inventoryId the ID of the inventory
*/
public void setInventoryId(int inventoryId) {
this.inventoryId = inventoryId;
}
/**

Returns the ID of the film associated with this inventory.
@return the ID of the film associated with this inventory
*/
public int getFilmID() {
return filmID;
}
/**

Sets the ID of the film associated with this inventory.
@param filmID the ID of the film associated with this inventory
*/
public void setFilmID(int filmID) {
this.filmID = filmID;
}
}
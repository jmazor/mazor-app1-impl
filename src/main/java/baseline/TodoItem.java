package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import java.util.Date;
import java.util.List;

public class TodoItem {
    private String itemName;
    private String dueDate;
    private String itemDescription;
    private Boolean completeFlag;
    private String itemID;

    public TodoItem(String itemName, String dueDate, String itemDescription) {
        // set this.itemName
        // call  changeDate
        // set this.itemDescription
        // set completeFlag to false
    }

    public void changeName(String itemName) {
        // change this.itemName
    }

    public void editDate(String dueDate) {
        // ensure date is in proper format
        // throw error if wrong format
        // can be empty
        // change this.dueDate
    }

    public void editDescription(String itemDescription) {
        // change this.itemDescription
    }

    public void changeFlag() {
        // change this.completeFlag to !this.completeFlag
    }

    public String getName() {
        // return name
        return itemName;
    }

    public String getDate() {
        // return dueDate
        return dueDate;
    }

    public String getDescription() {
        // return itemDescription
        return itemDescription;
    }

    public boolean getFlag() {
        // return completeFlag
        return completeFlag;
    }

    public String getID() {
        // return itemID
        return itemID;
    }

    public void editID(String ID) {
        // set this.itemID = ID
    }

}


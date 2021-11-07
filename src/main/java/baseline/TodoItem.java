package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TodoItem {
    private String itemName;
    private String dueDate;
    private String itemDescription;
    private CheckBox flag;

    public TodoItem() {
        itemName = null;
        dueDate = null;
        itemDescription = null;
        flag = new CheckBox();
    }

    public TodoItem(String itemName, String dueDate, String itemDescription) throws IOException, ParseException, IllegalArgumentException {
        // set this.itemName
        setItemName(itemName);
        // call  changeDate
        setDueDate(dueDate);
        // set this.itemDescription
        setDescription(itemDescription);
        // set completeFlag to false
        flag = new CheckBox();
        flag.setAllowIndeterminate(false);
    }


    public void setItemName(String itemName) throws IllegalArgumentException {
        // change this.itemName
        if (itemName.isBlank())
            throw new IllegalArgumentException();
        this.itemName = itemName;
    }

    public void setDueDate(String dueDate) throws ParseException {
        // ensure date is in proper format
        // throw error if wrong format
        // can be empty
        // change this.dueDate
        // allows for blank due dates
        if (!dueDate.isEmpty()) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            format.parse(dueDate);
        }
        this.dueDate = dueDate;

    }

    public void setDescription(String itemDescription) throws IOException {
        // change this.itemDescription
        if (itemDescription.length() > 256 || itemDescription.isBlank())
            throw new IOException();
        this.itemDescription = itemDescription;
    }


    public String getItemName() {
        // return name
        return itemName;
    }

    public String getDueDate() {
        // return dueDate
        return dueDate;
    }

    public String getItemDescription() {
        // return itemDescription
        return itemDescription;
    }

    public CheckBox getFlag() {
        // return completeFlag
        return this.flag;
    }

    public void setFlag(CheckBox checkBox) {
        this.flag =  checkBox;
    }

    public boolean compare(TodoItem cmp) {
        boolean ret = true;
        if (!this.getItemName().equals(cmp.getItemName()))
            ret = false;
        if (!this.getDueDate().equals(cmp.getDueDate()))
            ret = false;
        if (!this.getItemDescription().equals(cmp.getItemDescription()))
            ret = false;

        return ret;

    }


}


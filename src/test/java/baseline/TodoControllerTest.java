package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoControllerTest {

    @Test
    void handleDeleteList() {
        // should properly call todoList.deleteList
        // even though already tested we can ensure that the file has been removed from persistence
    }

    @Test
    void handleTitle() {
        // should move current file to new location
        // also make sure that the todoList.editFileName has been properly called
    }

    @Test
    void handleFlags() {
        // if flagged items is empty it should fill flagged items with completed flags
        // if pressed again should fill with uncompleted flags
        // should from then on switch back and forth from uncompleted to completed
        // will fill table data everytime
    }

    @Test
    void handleAddButton() {
        // ensure that the function to add to the object works approvingly
        // should be appropriately calling todoList.add()
    }

    @Test
    void handleDeleteButton() {
        // ensure that the selected ID is removed from the list
        // ID will be selected via click but we can specify
    }

    @Test
    void handleExit() {
        // ensure that a file is written on exit
    }

    @Test
    void setTable() {
        // this should set todoList to the passed TodoList
        // then should set table to this
    }

    @Test
    void setUpItem() {
        // should ensure Name is editable
        // on name change should update TodoList object
    }

    @Test
    void setUpDate() {
        // should ensure date is editable
        // should call editDate
        // will complain if wrong date
    }
    @Test
    void setUpDesc() {
        // should ensure desc is editable
        // on change should update TodoList object
    }
    @Test
    void setUpFlag() {
        // Flag should be a selectable checkbox
        // if box is clicked TodoList object will be updated
        // will switch boolean status
    }

    @Test
    void handleViewAll() {
        // should set table view to Full TodoList object list
        // will also set FlaggedItems to Null to reset
    }

    @Test
    void handleTextChange() {
        // on text change wil return the String ID of the Item changed
        // will then call modifyElement of that String
        // ensure proper ID is selected
    }

    @Test
    void modifyElement() {
        // will read from table fields
        // and will change the field selected in TodoList object
        // ensure that the TodoList object is updated
    }


}
package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {

    // create a TodoList

    @Test
    void addTodoItem() {
        // add an item and ensure it exists
        // make sure size of list has increased
        // the last value should be what we just added
    }

    @Test
    void add() {
        // add values and ensure they exist
        // make sure size of list has increased
        // the last value should be what we just added
        // also makes sure that all IDs are unique
    }

    void addFailure() {
        // try to create different items with the same ID
        // add should throw an exception
    }

    @Test
    void editName() {
        // make sure a new file exists in data
        // ensure that the old file has been removed
        // do this by reading the data/persistence directory
    }

    @Test
    void editDate() {
        // assert that after called date has been properly changed by calling get
        // this may change if I implement date datatype
    }

    @Test
    void editDesc() {
        //  change the desc
        // ensure that the new description is inputted by calling get
    }

    @Test
    void changeFlag() {
        // call change flag
        // if true should change to false
        // if false should change to true
    }

    @Test
    void delete() {
        // make sure item is deleted
        // ensure that listcount has decreased
    }

    @Test
    void editFileName() {
        // make sure that a new file has been created
        // make sure that the old file has been moved
    }

    @Test
    void getTodoList() {
        // returns list
    }

    @Test
    void getFileName() {
        // make sure that file name matches
    }

    @Test
    void get() {
        // make sure that the correct TodoItem is returned based on ID
    }

    @Test
    void getCompletedFlags() {
        // assert that the returned list contains only true flags
    }

    @Test
    void getUncompletedFlags() {
        // assert that the returned list contains only false flags
    }

    @Test
    void deleteList() {
        // assert that data is deleted from persistence
    }

    @Test
    void printToFile() {
        // new file contents should match list contents
        // read the new file to ensure this
    }




}
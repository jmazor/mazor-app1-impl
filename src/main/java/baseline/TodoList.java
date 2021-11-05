package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.collections.ObservableList;

import java.util.List;

public class TodoList {
    private ObservableList<TodoItem> dataList;
    private String fileName;

    public TodoList(List<TodoItem> inputList, String fileName) {
        // for every item in inputList
        // call this.addTodoItem()

        // set this.fileName to fileName
    }

    public void addTodoItem(TodoItem input) {
        // dataList.add(input)
    }

    public void add(String todoName, String todoDate, String todoDesc) {
        // TodoItem item = new TodoItem(todoName, todoDate, todoDesc)
        // String unique ID
        // Loop through todoList ensuring ID is unique
        // if not unique run again
        // if unique item.editID(ID)
        // dataList.add(item)
        // throw exception on error
    }

    public void editName(String itemID, String todoName) {
        // get(itemID).changeName(todoName)
    }

    public void editDate(String itemID, String todoDate) {
        // try catch
        // get(itemID).changeDate(todoDate)
        // throw on error
    }

    public void editDesc(String itemID, String todoDesc) {
        // get(itemID).changeDescription(todoDesc)
    }

    public void changeFlag(String itemID) {
        // get(itemID).changeFlag()
    }

    public void delete(String itemID) {
        // dataList.remove(get(itemID))
    }

    public void editFileName(String name) {
        // ensure filename is >3 chars
        // throw exception if not
        // create a new Filewriter object
        // mv this.fileName to name in ./data/persistence
        // (this will move all data)
        // this.fileName = name
    }

    public ObservableList<TodoItem> getTodoList() {
        // return dataList
        return dataList;
    }

    public String getFileName() {
       return fileName;
    }

    private int getIndex(String itemID) {
        // for every item in list
        // return index of TodoItem that matches ID
        return 0;
    }

    public TodoItem get(String itemID) {
        //int index  = getIndex(itemID)
        //return dataList.get(index)
        return null;
    }

    public ObservableList<TodoItem> getCompletedFlags() {
        // create a new Observable List
        // add any TodoItem to new list if completedFlag = true
        // return new list
        return null;
    }

    public ObservableList<TodoItem> getUncompletedFlags() {
        // create a new Observable List
        // add any TodoItem to new list if completedFlag = false
        // return new list
        return null;
    }

    public void deleteList() {
        // delete file from filename
    }

    public void printToFile() {
        // create a new file in data/persistence/this.fileName
        // print dataList in csv format
    }

}

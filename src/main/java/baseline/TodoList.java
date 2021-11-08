package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class TodoList {
    private ObservableList<TodoItem> dataList;
    private File fileName;


    public TodoList() {
        dataList = FXCollections.observableArrayList();
        fileName = null;
    }

    public void addTodoItem(TodoItem input) {
        if (dataList.size() > 200)
            throw new OutOfMemoryError();
        dataList.add(input);
    }

    public void add(String todoName, String todoDate, String todoDesc) throws IOException, ParseException, IllegalAccessError{
        // call addTodoItem memeber funcion
        TodoItem item = new TodoItem(todoName, todoDate, todoDesc);
        addTodoItem(item);
        fileName = null;
        // controller deals with Exceptions

    }

    public void editName(TodoItem item, String todoName) {
        item.setItemName(todoName);
    }

    public void editDate(TodoItem item, String todoDate) throws ParseException {
        // get(itemID).changeDate(todoDate)
        item.setDueDate(todoDate);
        // throw on error
    }

    public void editDesc(TodoItem item, String todoDesc) throws IOException {
        item.setDescription(todoDesc);
    }

    public void changeFlag(TodoItem item, CheckBox checkBox) {
        item.setFlag(checkBox);
    }

    public void delete(TodoItem item) {
        dataList.remove(item);
    }

    public void editFileName(File file) {
        if (file != null)
            fileName = file;
    }

    public ObservableList<TodoItem> getTodoList() {
        return dataList;
    }

    public File getFileName() {
       return fileName;
    }



    public ObservableList<TodoItem> getCompletedFlags() {
        // create a new Observable List
        ObservableList<TodoItem> completedFlags = FXCollections.observableArrayList();
        for (TodoItem item : dataList) {
            if (item.getFlag().isSelected())
                completedFlags.add(item);
        }
        // add any TodoItem to new list if completedFlag = true
        // return new list
        return completedFlags;
    }

    public ObservableList<TodoItem> getUncompletedFlags() {
        // create a new Observable List
        ObservableList<TodoItem> unCompletedFlags = FXCollections.observableArrayList();
        for (TodoItem item : dataList) {
            if (!item.getFlag().isSelected())
                unCompletedFlags.add(item);
        }
        // add any TodoItem to new list if completedFlag = false
        // return new list
        return unCompletedFlags;
    }

    public void clearList() {
        dataList.clear();
    }

    public void printToFile() {
        // create a new file in data/persistence/this.fileName
        try (FileWriter myWriter = new FileWriter(fileName)) {
            for (TodoItem item : dataList) {
                myWriter.write(item.getItemName() + ",");
                myWriter.write(item.getItemDescription() + ",");
                if (item.getDueDate().isEmpty()) {
                    myWriter.write(("\"\"" + ","));
                } else {
                    myWriter.write(item.getDueDate() + ",");
                }
                if (item.getFlag().isSelected())
                    myWriter.write("1");
                else
                    myWriter.write("0");
                myWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // print dataList in csv format
    }

    public void readData() throws IOException, ParseException {
        List<String> temp = new ArrayList<>();
            Scanner myReader = new Scanner(fileName);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                temp.addAll(Arrays.asList(data.split(",")));
            }
            myReader.close();
        inputData(temp);
    }

    private void inputData(List<String> data) throws IOException, ParseException, IllegalArgumentException {
        dataList.clear();
        TodoItem item = new TodoItem();
        int count = 0;
        for (String test : data) {
            ++count;
           count = count % 4;
           if (count == 1) {
               item.setItemName(test);
           }
           else if (count == 2) {
               item.setDescription(test);
           }
           else if (count == 3) {
               if (test.equals("\"\""))
                   test = "";
               item.setDueDate(test);
           }
           else if (count == 0){
               CheckBox checkBox = new CheckBox();
               if (test.equals("1")) {
                   checkBox.setSelected(true);
                   item.setFlag(checkBox);
               } else if (test.equals("0")) {
                   checkBox.setSelected(false);
                   item.setFlag(checkBox);
               }
               else {
                   throw new IOException();
               }
               dataList.add(item);
               item = new TodoItem();
           }

        }
    }

    public ObservableList<TodoItem> search (int flag, String name, String desc, String date) {
        ObservableList<TodoItem> searchList = null;
        if (flag == 0)
            searchList = FXCollections.observableArrayList(getTodoList());
        else if (flag == 1)
            searchList =FXCollections.observableArrayList(getCompletedFlags());
        else
            searchList = FXCollections.observableArrayList(getUncompletedFlags());

        if(!name.isBlank()) {
            searchList.removeIf(searchItem -> !searchItem.getItemName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)));
        }
        if(!desc.isBlank()) {
            searchList.removeIf(searchItem -> !searchItem.getItemDescription().toLowerCase(Locale.ROOT).contains(desc.toLowerCase(Locale.ROOT)));
        }

        if (!date.isBlank()) {
            searchList.removeIf(searchItem -> !searchItem.getDueDate().contains(date));
        }
     return  searchList;
    }
}

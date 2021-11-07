package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;


class TodoListTest {

    TodoList list;

    // create a TodoList
// init javafx toolkit
    void init() {
        Platform.startup(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    @Test
    void addTodoItem() throws IOException, ParseException {
        list = new TodoList();
        TodoItem item = new TodoItem("name", "1999-02-10", "desc");
        list.addTodoItem(item);
        assertTrue(item.compare(list.getTodoList().get(0)));
        // add an item and ensure it exists
        // make sure size of list has increased
        // the last value should be what we just added
    }

    @Test
    void add() throws IOException, ParseException {
        list = new TodoList();
        list.add("name", "1999-02-10", "desc");
        TodoItem item = new TodoItem("name", "1999-02-10", "desc");
        assertTrue(item.compare(list.getTodoList().get(0)));
        // add values and ensure they exist
        // make sure size of list has increased
        // the last value should be what we just added
        // also makes sure that all IDs are unique
    }


    @Test
    void editName() throws IOException, ParseException {
        list = new TodoList();
        list.add("first", "1999-02-10", "desc");
        list.editName(list.getTodoList().get(0), "new");
        assertEquals("new", list.getTodoList().get(0).getItemName());
        // make sure a new file exists in data
        // ensure that the old file has been removed
        // do this by reading the data/persistence directory

    }

    @Test
    void editDate() throws IOException, ParseException {

        // assert that after called date has been properly changed by calling get
        // The failure is already tested in TodoItemTest
        list = new TodoList();
        list.add("first", "1999-02-10", "desc");
        list.editDate(list.getTodoList().get(0), "2021-05-21");
        assertEquals("2021-05-21", list.getTodoList().get(0).getDueDate());

    }

    @Test
    void editDesc() throws IOException, ParseException {

        //  change the desc
        // ensure that the new description is inputted by calling get
        list = new TodoList();
        list.add("first", "1999-02-10", "desc");
        list.editDesc(list.getTodoList().get(0), "new");
        assertEquals("new", list.getTodoList().get(0).getItemDescription());
    }

    @Test
    void changeFlag() throws IOException, ParseException {
        list = new TodoList();
        list.add("first", "1999-02-10", "desc");
        CheckBox checkBox =  new CheckBox();
        checkBox.setSelected(true);
        list.changeFlag(list.getTodoList().get(0), checkBox);
        assertTrue(list.getTodoList().get(0).getFlag().isSelected());
        // call change flag
        // if true should change to false
        // if false should change to true
    }

    @Test
    void delete() throws IOException, ParseException {
        // make sure item is deleted
        // ensure that listcount has decreased
        list = new TodoList();
        list.add("first", "1999-02-10", "desc");
        list.add("second", "1999-02-10", "desc");
        list.delete(list.getTodoList().get(1));
    }

    @Test
    void editFileName() {
        list = new TodoList();
        File file = new File("./test");
        list.editFileName(file);
        assertEquals(file, list.getFileName());

    }

    @Test
    void getUncompletedFlagsTest() throws IOException, ParseException {
        list = new TodoList();
        list.add("first", "1999-02-10", "desc");
        list.add("second", "1999-02-10", "desc");
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(true);
        list.getTodoList().get(1).setFlag(checkBox);
        ObservableList<TodoItem> test = list.getUncompletedFlags();
        assertEquals(1, test.size());
        assertEquals(list.getTodoList().get(0), test.get(0));

        // returns list
    }





}
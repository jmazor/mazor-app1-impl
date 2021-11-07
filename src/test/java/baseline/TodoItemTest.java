package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import com.sun.jdi.event.ClassUnloadEvent;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {
    TodoItem item;

    // init javafx toolkit
    void init() {
        Platform.startup(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
    // create a TodoItem


    @Test
    void TodoItem() throws IOException, ParseException {
        item = new TodoItem("name", "1999-02-10", "desc");
        boolean flag = true;
        if (!item.getItemName().equals("name"))
            flag = false;
        if (!item.getDueDate().equals("1999-02-10"))
            flag = false;
        if (!item.getItemDescription().equals("desc"))
            flag = false;

        assertTrue(flag);
    }

    @Test
    void changeName() throws IOException, ParseException {
        item = new TodoItem("name", "1999-02-10", "desc");
        item.setItemName("monkey");
        assertEquals("monkey", item.getItemName());

    }

    @Test
    void editDateFail() throws IOException, ParseException {
        item = new TodoItem("name", "1999-02-10", "desc");

        boolean flag = true;
        try {
            item.setDueDate("junk");
        }
        catch (Exception e) {
            flag = false;
        }
        assertFalse(flag);
    }

    @Test
    void editDate() throws IOException, ParseException {
        // ensure we can properly edit the Date of a TodoItem
        item = new TodoItem("name", "1999-02-10", "desc");
        item.setDueDate("2000-02-10");
        // assert getDate after changed
        assertEquals("2000-02-10", item.getDueDate());
        // ensure that date must be in proper format
    }

    @Test
    void editDescription() throws IOException, ParseException {
        item = new TodoItem("name", "1999-02-10", "desc");
        // ensure we can properly edit the desc of a TodoItem
        item.setDescription("test");
        assertEquals("test", item.getItemDescription());
        // assert getDescription after changed
    }

    @Test
    void changeFlag() throws IOException, ParseException {
        init();
        item = new TodoItem("name", "1999-02-10", "desc");
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(true);
        item.setFlag(checkBox);
        assertTrue(item.getFlag().isSelected());

    }

    @Test
    void compareTest() throws IOException, ParseException {
        item = new TodoItem("name", "1999-02-10", "desc");
        TodoItem cmp = new TodoItem("name", "1999-02-10", "desc");
        assertTrue(item.compare(cmp));
    }



}
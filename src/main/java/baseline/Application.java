package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TodoList.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        TodoController controller = fxmlLoader.<TodoController>getController();
        // Load Opening Screen and TodoList
        // String fileName;
        // show Opening screen untill a fileName is recieved
        // while OpeningScreencontroller.getFileName() is null
        // depending on lag we will only call getFileName() every second or a few times a second....
        // i have not found a proper listener solution so this solution is hopefully temporary untill I find the proper logic
        // once a fileName is received hide Opening Screen
        // call todoListController.setTable(readData(fileName)
        // init and show table
        Scene scene = new Scene(root, 600, 400);


        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    private static TodoList readData(String name)  {
        // find the file at String name
        // while we will have error checking we can be sure this file exists due to choiceBox

        // read and parse a csv file
        // create a List<TodoItem>
        // for every line create a new TodoItem add it to the list
        // if error crash the program and return error data has been tampered or corrupted

        // return a new TodoList(List, name)
        return null;
    }
}


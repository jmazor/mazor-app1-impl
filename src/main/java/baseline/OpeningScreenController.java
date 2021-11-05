package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OpeningScreenController implements Initializable {

    // If we can implement a listener we will listen to this variable
    // currently we just call getFileName untill we receive a response
    private String fileName;

    @FXML
    private Button createNewList;

    @FXML
    private Button exportList;

    @FXML
    private Button importList;

    @FXML
    private ChoiceBox<String> listChoice;

    @FXML
    private TextField newList;

    @FXML
    private Button openList;

    @FXML
    public void handleCreate() {
        // create newFile from newList name
        // set String to fileName to newList
    }

    @FXML
    public void handleOpening() {
        // set fileName to listChoice selection
    }

    @FXML
    public void handleImport() {
        // open a file explorer
        // I will need to research how to do this
        // select a file to be imported
        // call checkImport
        // if true copy file to persistence and set fileName
        // if false complain

    }

    private boolean checkImport(String importFile) {
        // read importFile data
        // ensure it is a csv file that can be parsed into the proper 4 column table
        // return status
        return false;
    }

    @FXML
    public void handleExport() {
        // select File from listChoice
        // ask user for a file name
        // copy file to new location
    }

    public String getFileName() {
        // return fileName
        return fileName;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // read all fileNames from ./data/persistence
        // set listChoice to all file names read
    }

}

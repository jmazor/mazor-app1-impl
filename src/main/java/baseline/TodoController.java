package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class TodoController implements Initializable {

    // Spreadsheet data
    private TodoList todoList;
    private ObservableList<TodoItem> flaggedItems;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField inputDate;

    @FXML
    private TextField inputDesc;

    @FXML
    private TextField inputName;

    @FXML
    private TableView<TodoItem> table;

    @FXML
    private TableColumn<TodoItem, String> todoDate;

    @FXML
    private TableColumn<TodoItem, String> todoDesc;

    @FXML
    private TableColumn<TodoItem, Boolean> todoFlag;

    @FXML
    private TableColumn<TodoItem, String> todoItem;

    @FXML
    private Menu exitMenu;

    @FXML
    private MenuItem completedItems;

    @FXML
    private MenuItem deleteList;

    @FXML
    private MenuItem changeTitle;

    @FXML
    private MenuItem viewAll;

    @FXML
    public void handleDeleteList() {
        // TodoList.deleteList
        // TODO
        // I need to research if i can listen to a method somehow like listing to a port
        // if I can accomplish this we will return to the original screen on delete

        // Currently I will close the program.

        // TODO
        // we print to file on close so ensure if we implement a listener to no print file
    }

    @FXML
    public void handleTitle() {
        // prompt User for new title
        // either this or file explorer. (This program seems to abstract away from files so I doubt this will be the case)
        // try catch
        // todoList.editFileName();

        // if catch complain and ask again
    }


    @FXML
    public void handleFlags() {
        // if finished item is null
        // set flaggedItems  = todoList.getCompletedFlags()

        // else if flaggedItems.get(0).getFlag is true
        // this works because we do not modify the flaggedItems list, only the display and todoList gets modified
        // set flaggedItems = todoList.getUncompletedFlags()

        // else set flaggedItems = todolist.getCompleteFlags()

        // set table Data to flaggedItems
    }

    @FXML
    public void handleAddButton() {
        // create a new person
        // read data from inputName inputDesc and inputDate
        // try catch
        // call todoList.add()
        // catch display error message
    }

    @FXML
    public void handleDeleteButton() {
        // determine ID from selected table field
        // call todoList.delete(ID)
        // This actually deletes it from the List
        // our checkbox should be how you mark an item as done
    }

    @FXML
    public void handleExit() {
        // call printToFile()
        // exit program safely
    }

    @FXML
    public void handleViewAll() {
        // set flaggedItems to NULL
        // set table to todoList.getList()
    }


    // This along with the method below are backup methods
    // If i did not understand JavaFX functionally correctly
    @FXML
    public void handleTextChange() {
        // on edit change of table
        // get ID of TodoItem Changed
        // This will only stay if FXML does not let me edit individual fields
        // This backup method I would a new class variable called ID and set it here
        // modifyElement()
    }


    // IMPORTANT
    // All of these setUp commands are contingent on the fact that JavaFX will properly respond with the correct
    // TodoItem selected
    // If this is not the case I have already implemented a backup plan using handleTextChange
    // This is what the Backup Method will look like

    public void modifyElement(String ID) {
        // read all fields
        // todoList.editName(ID, newName)
        // todoList.editDate(ID, newdate)
        // todoList.editDesc(ID, newDesc)
        // todoList.changeFlag(ID)

    }


    public void setTable(TodoList inputData) {
        // set todoList = inputData
        // set table to todoList.getTable
    }

    // All setup items are public for unit testing

    public void setUpItem() {
        // set todoItem to editabale
        // on todoItem edit call todoList.editName()
    }

    public void setUpDate() {
        // set todoDate to editable
        // try catch
        // on todoDate edit call todoList.editDate()
        // on catch complain
    }

    public void setUpDesc() {
        // set todoDesc to editable
        // on todoDesc edit call todoList.editDesc()
    }

    public void setUpFlag() {
        // make todoFlag an editable Checkbox cell
        // on edit call todoList.changeFlag()
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set Item Column
        // set Date Column
        // set Desc column
        // set flag column
        // set table data to todoList.getList()
        // set table to editable
        // call setUpItem
        // setUpName
        // setUpDate
        // setUpDesc
        // setUpFlag




    }
}


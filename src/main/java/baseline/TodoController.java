package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TodoController implements Initializable {

    // Spreadsheet data
    private TodoList todoList;
    private int flag;

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
    private TableColumn<TodoItem, String> dueDate;

    @FXML
    private TableColumn<TodoItem, String> itemDescription;

    @FXML
    private TableColumn<TodoItem, CheckBox> todoFlag;

    @FXML
    private TableColumn<TodoItem, String> itemName;


    @FXML
    private MenuItem completedItems;

    @FXML
    private MenuItem clearList;


    @FXML
    private MenuItem viewAll;

    @FXML
    private MenuItem uncompletedItems;

    @FXML
    public void handleClearList() {
        // clears list
        todoList.clearList();
        flag = 0;
    }

    @FXML
    public void handleCompletedFlags() {
        flag = 1;
        updateState();
    }

    @FXML
    public void handleAddButton() {
        // read data from inputName inputDesc and inputDate
        try
        {
            todoList.add(inputName.getCharacters().toString(), inputDate.getCharacters().toString(), inputDesc.getCharacters().toString());
        } catch (IOException e) {
            popupError("Please enter a valid description of 1 to 256 characters");
        } catch (ParseException e) {
            popupError("Please enter a valid date in the format YYYY-MM-DD");

        } catch (IllegalArgumentException e) {
            popupError("Please enter a valid TODO name");
        } catch (OutOfMemoryError e) {
            popupError("List cannot contain more than 200 records");
        }
        // create a new person
        // try catch
        // call todoList.add()
        // catch display error message
        inputName.clear();
        inputDesc.clear();
        inputDate.clear();
        updateState();
    }

    @FXML
    public void handleDeleteButton() {
        // determine ID from selected table field
        todoList.delete(table.getItems().get(0));
        updateState();
        // call todoList.delete(ID)
        // This actually deletes it from the List
        // our checkbox should be how you mark an item as done
    }


    @FXML
    public void handleViewAll() {


        flag = 0;
        updateState();
        // set flaggedItems to NULL
        // set table to todoList.getList()
    }

    @FXML
    private void handleUncompletedFlags() {
        flag = 2;
        updateState();
    }

    @FXML
    public void handleOpenList() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(table.getScene().getWindow());
        todoList.editFileName(file);
        try {
            todoList.readData();
            flag = 0;
        }
        catch (Exception e) {
            popupError("File is invalid or corrupted");
        }
        updateState();
    }

    @FXML
    public void handleExportList() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showSaveDialog(table.getScene().getWindow());
        todoList.editFileName(file);
        todoList.printToFile();

    }

    @FXML
    public void handleSearchButton() {

        table.setItems(todoList.search(flag, inputName.getCharacters().toString(), inputDesc.getCharacters().toString(), inputDate.getCharacters().toString()));
        inputName.clear();
        inputDesc.clear();
        inputDate.clear();

    }




    // All setup items are public for unit testing

    public void setUpItem() {
        // set todoItem to editabale
        itemName.setCellValueFactory(new PropertyValueFactory<TodoItem, String>("itemName"));
        itemName.setCellFactory(TextFieldTableCell.forTableColumn());
        itemName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TodoItem, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<TodoItem, String> event) {
                TodoItem test = event.getRowValue();
                try {
                    todoList.editName(test, event.getNewValue());
                }
                catch (Exception e) {
                    popupError("Please enter a valid TODO name");
                }
                table.refresh();

            }
        });
        // on todoItem edit call todoList.editName()
    }

    public void setUpDate() {
        // set todoDate to editable
            // try catch
            // on todoDate edit call todoList.editDate()
            // on catch complain
        dueDate.setCellValueFactory(new PropertyValueFactory<TodoItem, String>("dueDate"));
        dueDate.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDate.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TodoItem, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<TodoItem, String> event) {
                TodoItem newItem = event.getRowValue();
                try {
                    todoList.editDate(newItem, event.getNewValue());
                }
                catch (Exception e) {
                    popupError("Please enter a valid date in YYYY-MM-DD format");
                    table.refresh();
                }

            }
        });
        }

    public void setUpDesc() {

        // set todoDesc to editable
        itemDescription.setCellValueFactory(new PropertyValueFactory<TodoItem, String>("itemDescription"));
        itemDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        itemDescription.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TodoItem, String>>() {

            @Override
            public void handle(TableColumn.CellEditEvent<TodoItem, String> event) {
                TodoItem newItem = event.getRowValue();
                try {
                    todoList.editDesc(newItem, event.getNewValue());
                }
                catch (Exception e) {
                    popupError("Please enter a valid description of 1 to 256 characters");
                }
                table.refresh();

            }
        });
        // on todoDesc edit call todoList.editDesc()
    }

    public void setUpFlag() {
        todoFlag.setCellValueFactory(new PropertyValueFactory<TodoItem, CheckBox>("flag"));
        todoFlag.setEditable(true);

        // make todoFlag an editable Checkbox cell
        // on edit call todoList.changeFlag()
    }

    private void updateState() {
        if (flag == 0)
            table.setItems(todoList.getTodoList());
        if (flag == 1)
            table.setItems(todoList.getCompletedFlags());
        if (flag == 2)
            table.setItems(todoList.getUncompletedFlags());
    }

    private void popupError(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        todoList = new TodoList();
        // set itemColumn
        // set Date Column
        // set Desc column
        // set flag column
        // set table data to todoList.getList()
        // table.setItems(todoList.getTodoList())
        // set table to editable
        table.setEditable(true);
        // call setUpItem
        // setUpName
        setUpItem();
        setUpFlag();
        // setUpDate
        // setUpDesc
        setUpDesc();
        setUpDate();
        // setUpFlag
        flag = 0;
        updateState();

    }
}


package pl.polsl.lab.datingapp.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.polsl.lab.datingapp.model.entities.Person;

import java.util.List;

/**
 * Controller class to control DateResultsDialog.fxml view file
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class DateResultsDialogController {
    /** reference for table from fxml file */
    @FXML private TableView<Person> table = new TableView();
    /** reference for first name table column field from fxml file */
    @FXML private TableColumn<Person, String> firstNameCol;
    /** reference for last name table column field from fxml file */
    @FXML private TableColumn<Person, String> lastNameCol;
    /** reference for gender table column field from fxml file */
    @FXML private TableColumn<Person, String> genderCol;
    /** reference for age table column field from fxml file */
    @FXML private TableColumn<Person, Number> ageCol;
    /** reference for hobbies table column field from fxml file */
    @FXML private TableColumn<Person, String> hobbiesCol;

    /**
     * Method which is executed when the fxml file is loaded
     */
    @FXML public void initialize() {
        firstNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFirstName()));
        lastNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastName()));
        genderCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender().toString()));
        ageCol.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAge()));
        hobbiesCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPreferences().getHobbies().toString()));

        table.getColumns().setAll(firstNameCol, lastNameCol, genderCol, ageCol, hobbiesCol);
    }

    /**
     * Set list of persons which will be shown in the table
     * @param list person list which will be shown
     */
    public void setPersonList(List<Person> list) {
        table.getItems().clear();
        table.getItems().addAll(list);
    }
}

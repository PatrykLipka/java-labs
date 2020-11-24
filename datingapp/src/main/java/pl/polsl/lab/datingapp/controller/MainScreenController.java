package pl.polsl.lab.datingapp.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import pl.polsl.lab.datingapp.model.entities.Person;
import pl.polsl.lab.datingapp.model.entities.Preferences;
import pl.polsl.lab.datingapp.model.enums.Gender;
import pl.polsl.lab.datingapp.model.enums.Hobby;
import pl.polsl.lab.datingapp.model.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class to control MainScene.fxml view file
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class MainScreenController {
    /** reference for first name text field from fxml file */
    @FXML private TextField firstNameTextField;
    /** reference for last name text field from fxml file */
    @FXML private TextField lastNameTextField;
    /** reference for birthday date text field from fxml file */
    @FXML private TextField birthdayDateTextField;
    /** reference for gender choice box from fxml file */
    @FXML private ChoiceBox<Gender> genderChoiceBox;
    /** reference for preference gender choice box from fxml file */
    @FXML private ChoiceBox<Gender> prefGenderChoiceBox;
    /** reference for maximal age difference spinner from fxml file */
    @FXML private Spinner<Integer> maxAgeDiffSpinner;
    /** reference for checked hobbies flow pane from fxml file */
    @FXML private FlowPane hobbyCheckboxesFlowPane;
    /** reference for button fxml file */
    @FXML private Button lookForDateButton;

    /** controller which controls person repository */
    private PersonController personController;

    /** initial spinner value */
    private final int initialSpinnerValue = 0;

    /**
     * Non argument constructor
     */
    public MainScreenController() {
        personController = new PersonController(new PersonRepository());
    }

    /**
     * Method which get all selected by checkboxes hobbies
     * @return selected hobbies as a list
     */
    private List<Hobby> getSelectedHobbies() {
        List<Hobby> result = new ArrayList<>();
        for(int i = 0; i < hobbyCheckboxesFlowPane.getChildren().size(); i++) {
            Node n = hobbyCheckboxesFlowPane.getChildren().get(i);
            if(n instanceof CheckBox) {
                if (((CheckBox)n).isSelected()) {
                    result.add(Hobby.getAllValues().get(i));
                }
            }
        }
        return result;
    }

    /**
     * Method which check is all values filled
     * @return is all values filled boolean
     */
    private boolean isAllValuesFilled() {
        return (firstNameTextField.getText() != "" &&
                lastNameTextField.getText() != "" &&
                birthdayDateTextField.getText() != "" &&
                !getSelectedHobbies().isEmpty());
    }

    /**
     * Method which is executed when the fxml file is loaded
     */
    @FXML public void initialize() {
        genderChoiceBox.setItems(FXCollections.observableArrayList(Gender.getAllValues()));
        genderChoiceBox.getSelectionModel().selectFirst();
        prefGenderChoiceBox.setItems(FXCollections.observableArrayList(Gender.getAllValues()));
        prefGenderChoiceBox.getSelectionModel().selectFirst();
        for(Hobby h : Hobby.getAllValues()) {
            hobbyCheckboxesFlowPane.getChildren().add(new CheckBox(h.toString()));
        }

        maxAgeDiffSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50, initialSpinnerValue));
    }


    /**
     * Look for date button on click handler
     * @param event button event
     */
    @FXML private void handleLookForDateButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(isAllValuesFilled()) {
            try {
                alert.setTitle("Date found!");
                alert.setHeaderText("Your date details:");

                Person person = new Person();
                person.setFirstName(firstNameTextField.getText());
                person.setLastName(lastNameTextField.getText());
                person.setDateOfBirth(birthdayDateTextField.getText());
                person.setGender(genderChoiceBox.getValue());

                Preferences preferences = new Preferences();
                preferences.setAgeDifference(maxAgeDiffSpinner.getValue());
                preferences.setHobbies(getSelectedHobbies());
                preferences.setInterestGender(prefGenderChoiceBox.getValue());

                person.setPreferences(preferences);
                alert.setContentText(personController.findADate(person).toString());
            } catch (Exception e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("An error occurred");
                alert.setContentText(e.getMessage());
            }
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Values missing error");
            alert.setContentText("Fill all values and try again!");
        }
        alert.showAndWait();
    }
}

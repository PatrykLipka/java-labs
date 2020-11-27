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
import pl.polsl.lab.datingapp.view.DateResultsDialog;

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
        if(isAllValuesFilled()) {
            try {
                Preferences preferences = new Preferences(
                        maxAgeDiffSpinner.getValue(),
                        prefGenderChoiceBox.getValue(),
                        getSelectedHobbies());

                Person person = new Person(
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        genderChoiceBox.getValue(),
                        birthdayDateTextField.getText(),
                        preferences);

                List<Person> resultList = new ArrayList<>();
                resultList.add(personController.findADate(person));

                DateResultsDialog dialog = new DateResultsDialog(resultList);
                dialog.show();
            } catch (Exception e) {
                showErrorAlert(e.getMessage());
            }
        } else {
            showErrorAlert("Fill all values and try again!");
        }
    }

    /**
     * Show error alert
     * @param message messege which will be shown
     */
    void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("An error occurred");
        alert.setContentText(message);
        alert.showAndWait();
    }
}

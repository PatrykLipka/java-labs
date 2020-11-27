package pl.polsl.lab.datingapp.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.stage.Window;
import pl.polsl.lab.datingapp.controller.DateResultsDialogController;
import pl.polsl.lab.datingapp.model.entities.Person;

import java.io.IOException;
import java.util.List;

/**
 * Class of custom date results dialog
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class DateResultsDialog extends Dialog {

    /**
     * Class constructor
     * @param listToShow list of persons which will be shown
     */
    public DateResultsDialog(List<Person> listToShow) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DateResultsDialog.fxml"));
            Parent root = loader.load();
            DateResultsDialogController controller = loader.getController();
            controller.setPersonList(listToShow);
            Window window = getDialogPane().getScene().getWindow();
            window.setOnCloseRequest(event -> window.hide());
            getDialogPane().setContent(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

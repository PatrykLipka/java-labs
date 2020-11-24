/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab.datingapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class - start point of the program
 * @version 0.0.1
 * @author tomas
 */
public class Main extends Application {

        @Override
        public void start(Stage stage) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("view/MainScreen.fxml"));

                Scene scene = new Scene(root, 620, 715);

                stage.setTitle("Dating app");
                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch();
        }
}

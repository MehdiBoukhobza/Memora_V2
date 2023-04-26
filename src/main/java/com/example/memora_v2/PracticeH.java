package com.example.memora_v2;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PracticeH extends Navbar implements Initializable {
    @FXML
    private Button tenButton;
    @FXML
    private Button twentyButton;
    @FXML
    private Button allButton;

    static int session = 1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        tenButton.setOnMouseClicked(event -> {
            try {
                switchTo(event, "practice.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        twentyButton.setOnMouseClicked(event -> {
            try {
                session = 0;
                switchTo(event, "practice.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        allButton.setOnMouseClicked(event -> {
            try {
                session = 2;
                switchTo(event, "practice.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}

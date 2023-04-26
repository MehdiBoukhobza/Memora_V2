package com.example.memora_v2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddCard extends Navbar {
    @FXML
    public TextArea myAreaQuestion;
    @FXML
    public TextArea myAreaAnswer;
    @FXML
    public Label SuccessMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

    }

    public void addCard(ActionEvent event) {
        String question = myAreaQuestion.getText();
        String answer = myAreaAnswer.getText();


        if (question.isBlank() || answer.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("There is no sin except stupidity.");
            Label contentLabel = new Label("Come on man, you clearly haven't entered any question and/or answer, " +
                    "and somehow, by some miracle, you expect to add a blank card ");
            contentLabel.setStyle("-fx-font-family: 'Ubuntu Regular'");
            contentLabel.setWrapText(true);

            alert.getDialogPane().setContent(contentLabel);
            alert.getDialogPane().setPrefWidth(400);
            alert.getDialogPane().setPrefHeight(200);
            alert.showAndWait();
            return;
        }

        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();


        String connectQuery1 = "INSERT INTO cards (Question, Answer) VALUES ('" + question + "','" + answer + "')";
        String connectQuery2 = "INSERT INTO bad_cards (id) SELECT id FROM cards ORDER BY id DESC LIMIT 1;";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectQuery1);
            statement.executeUpdate(connectQuery2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        SuccessMessage.setStyle("-fx-opacity: 1;");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event1 -> {
            SuccessMessage.setStyle("-fx-opacity: 0;");
        }));
        timeline.playFromStart();
    }


}

package com.example.memora_v2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AddCard extends Navbar  {
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

    public void addCard(ActionEvent event){
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();

        String question = myAreaQuestion.getText();
        String answer = myAreaAnswer.getText();

        String connectQuery = "INSERT INTO cards (Question, Answer, Weight) VALUES ('"+question+"','"+answer+"', 5)";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectQuery);

        } catch(Exception e){
            e.printStackTrace();
        }
        SuccessMessage.setStyle("-fx-opacity: 1;");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event1 -> {
            SuccessMessage.setStyle("-fx-opacity: 0;");
        }));
        timeline.playFromStart();
    }




}

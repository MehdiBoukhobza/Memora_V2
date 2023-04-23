package com.example.memora_v2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DMCard extends Navbar {

    @FXML
    private Label myQuestionLabel;
    @FXML
    private Label myAnswerLabel;
    @FXML
    private Label SuccessMessage;


    int Id = Manage.Id;
    DataBase connectNow = new DataBase();
    Connection connectDB = connectNow.getConnection();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        displayCard();

    }

    public void displayCard() {


        String connectQuery = " SELECT Question, Answer FROM cards where id = " + Id + " ";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                myQuestionLabel.setText(queryOutput.getString("Question"));
                myAnswerLabel.setText(queryOutput.getString("Answer"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCard(ActionEvent event) {
        String connectQuery1 = " DELETE FROM cards WHERE id = "+ Id +" ";
                String connectQuery2 = " CREATE TABLE tmp_cards ( id INT AUTO_INCREMENT PRIMARY KEY, Question LONGTEXT, Answer LONGTEXT, Weight INT)";
                String connectQuery3 = " INSERT INTO tmp_cards (Question, Answer) SELECT Question, Answer FROM cards";
                String connectQuery4 = " DROP TABLE cards ";
                String connectQuery5 = " RENAME TABLE tmp_cards TO cards";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectQuery1);
            statement.executeUpdate(connectQuery2);
            statement.executeUpdate(connectQuery3);
            statement.executeUpdate(connectQuery4);
            statement.executeUpdate(connectQuery5);

        } catch (Exception e) {
            e.printStackTrace();
        }
        SuccessMessage.setStyle("-fx-opacity: 1;");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event1 -> {
            SuccessMessage.setStyle("-fx-opacity: 0;");
        }));
        timeline.playFromStart();
    }

    public void switchToModify(ActionEvent event) throws IOException {
        switchTo(event, "modifyCard.fxml");

    }


}

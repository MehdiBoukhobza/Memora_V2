package com.example.memora_v2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ModifyCard extends Navbar{
    @FXML
    private TextArea myModifyQuestion;
    @FXML
    private TextArea myModifyAnswer;
    @FXML
    private Label SuccessMessage;

    int Id = Manage.Id;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        modify();




    }


    public void modify(){
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();


        String connectQuery = " SELECT Question, Answer FROM cards where id = "+Id+" ";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()){
                myModifyQuestion.setText(queryOutput.getString("Question"));
                myModifyAnswer.setText(queryOutput.getString("Answer"));


            }

        } catch(Exception e){
            e.printStackTrace();
        }


    }

    public void save(ActionEvent event){
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();

        String questionU = myModifyQuestion.getText();
        String answerU = myModifyAnswer.getText();
        System.out.println(questionU + answerU);


        String connectQuery = " UPDATE cards SET Question = '"+questionU+"', Answer = '"+answerU+"' WHERE id = "+Id+" ";
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



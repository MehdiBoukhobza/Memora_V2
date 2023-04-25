package com.example.memora_v2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

public class Practice extends Navbar {
    @FXML
    private Rectangle questionText;
    @FXML
    private Label LabelAnswer;
    @FXML
    private Group Title_QA;
    @FXML
    private Text questionP;
    @FXML
    private Button perfectButton;
    @FXML
    private Button goodButton;
    @FXML
    private Button badButton;

    private String Answer;

    private String Question;
    private List<Integer> ListOfIds = new ArrayList<>();
    private int i = 1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        practiceCardsDB(Settings.quickPractice);

        selectCard(ListOfIds.get(0));
        LabelAnswer.setText(Question);
        LabelAnswer.setOnMouseClicked(this::flipCard);
    }
    public void flipCard(MouseEvent event){
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), questionText);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(180);
        rotateTransition.play();

        Title_QA.setStyle("-fx-opacity: 0;");
        LabelAnswer.setStyle("-fx-opacity: 0;");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.1), event1 -> {
            questionP.setText("Answer");
            questionP.setTranslateX(11);
            Title_QA.setStyle("-fx-opacity: 1;");
            LabelAnswer.setText(Answer);
            LabelAnswer.setStyle("-fx-opacity: 1;");
        }));
        timeline.playFromStart();
    }

    public void practiceCardsDB (float numberOfCards) {
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();
        String connectQueryBad = "SELECT id FROM bad_cards ORDER BY RAND() LIMIT "+(int)(numberOfCards*0.6)+" ";
        String connectQueryGood = "SELECT id FROM good_cards ORDER BY RAND() LIMIT "+(int)(numberOfCards*0.3)+" ";
        String connectQueryPerfect = "SELECT id FROM perfect_cards ORDER BY RAND() LIMIT "+(int)(numberOfCards*0.1)+" ";


        try {
            Statement statement = connectDB.createStatement();

            ResultSet queryOutputBad = statement.executeQuery(connectQueryBad);



            while (queryOutputBad.next()) {
                ListOfIds.add(queryOutputBad.getInt("id"));
            }
            ResultSet queryOutputGood = statement.executeQuery(connectQueryGood);
            while (queryOutputGood.next()) {
                ListOfIds.add(queryOutputGood.getInt("id"));
            }
            ResultSet queryOutputPerfect = statement.executeQuery(connectQueryPerfect);
            while (queryOutputPerfect.next()) {
                ListOfIds.add(queryOutputPerfect.getInt("id"));
            }
            Collections.shuffle(ListOfIds);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ListOfIds);
    }

    public void selectCard(int id){
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();
        String connectQuery = " SELECT Question, Answer FROM cards where id = " + id + " ";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                Question = queryOutput.getString("Question");
                Answer = queryOutput.getString("Answer");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void perfect(Event event)  {
        if (ListOfIds.isEmpty()){
            System.out.println("it's done");
            return;
        }
        selectCard(ListOfIds.get(i));
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), questionText);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(-180);
        rotateTransition.play();

        Title_QA.setStyle("-fx-opacity: 0;");
        LabelAnswer.setStyle("-fx-opacity: 0;");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1.1), event1 -> {
            questionP.setText("Question");
            questionP.setTranslateX(-5);
            Title_QA.setStyle("-fx-opacity: 1;");
            LabelAnswer.setText(Question);
            LabelAnswer.setStyle("-fx-opacity: 1;");
        }));
        timeline.playFromStart();
        i++;
    }
}







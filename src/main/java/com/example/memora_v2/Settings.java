package com.example.memora_v2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Settings extends Navbar {

    @FXML
    private TextArea uName;
    @FXML
    private TextArea uBio;
    @FXML
    private TextArea uquick;
    @FXML
    private TextArea uMedium;
    @FXML
    private Label SuccessMessage;

    static int quickPractice;
    static int mediumPractice;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        display();
    }

    public void display() {
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = " SELECT * FROM user";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                uName.setText(queryOutput.getString("FullName"));
                uBio.setText(queryOutput.getString("Bio"));
                uquick.setText(String.valueOf(queryOutput.getInt("Nb_Quick")));
                uMedium.setText(String.valueOf(queryOutput.getInt("Nb_Medium")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void save() {
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();

        String Name = uName.getText();
        String Bio = uBio.getText();
        quickPractice = Integer.parseInt(uquick.getText());
        mediumPractice = Integer.parseInt(uMedium.getText());


        String connectQuery1 = " UPDATE user SET FullName = '" + Name + "', Bio = '" + Bio + "', Nb_Quick = " + quickPractice + ", Nb_Medium= " + mediumPractice + " Where id = "+1+" " ;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectQuery1);
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

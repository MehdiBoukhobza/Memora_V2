package com.example.memora_v2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Account extends Navbar {

    @FXML
    private Label nameLabel;
    @FXML
    private Label labelBio;
    @FXML
    private Label numberChosenQuick;
    @FXML
    private Label numberChosenMedium;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        displayAll();
    }

    public void displayAll(){
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = " SELECT * FROM user";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                nameLabel.setText(queryOutput.getString("FullName"));
                labelBio.setText(queryOutput.getString("Bio"));
                numberChosenQuick.setText(queryOutput.getString("Nb_Quick"));
                numberChosenMedium.setText(queryOutput.getString("Nb_Medium"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

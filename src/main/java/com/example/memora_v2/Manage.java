package com.example.memora_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class Manage extends Navbar  {

    @FXML
    private ImageView plusIcon;
    @FXML
    private ListView<String> myListView;

    private ObservableList<String> Questions = FXCollections.observableArrayList();
    static int Id;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        plusIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                switchTo(event, "addCard.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        updateList();

        myListView.setPrefHeight(320);
        myListView.setItems(Questions);
        myListView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                switchToDMCard(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });




    }


    public void switchToDMCard(MouseEvent event) throws IOException {
        Id = myListView.getItems().size() - myListView.getSelectionModel().getSelectedIndex();
        System.out.println(Id);

        switchTo(event, "DMCard.fxml");

    }

    public void switchToAddCardB(ActionEvent event) throws IOException {
        switchTo(event, "addCard.fxml");
    }

    public void updateList(){
        DataBase connectNow = new DataBase();
        Connection connectDB = connectNow.getConnection();


        String connectQuery = "SELECT * FROM cards ORDER BY id DESC";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()){
                Questions.add(queryOutput.getString("id") + ".  " + queryOutput.getString("Question"));
            }

        } catch(Exception e){
            e.printStackTrace();
        }



    }












}

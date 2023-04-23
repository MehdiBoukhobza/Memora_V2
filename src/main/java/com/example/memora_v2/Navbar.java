package com.example.memora_v2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Navbar implements Initializable  {

    @FXML
    private Group myPracticeGroup;
    @FXML
    private Group MyLogoutGroup;
    @FXML
    private Group MySettingGroup;
    @FXML
    private Group MyAccountGroup;
    @FXML
    private Group myManageGroup;

    @FXML
    private Rectangle R_practice;
    @FXML
    private Text practiceText;
    @FXML
    private ImageView Icon_practice;
    @FXML
    private  Rectangle R_manage;
    @FXML
    private  Text manageText;
    @FXML
    private  ImageView Icon_manage;
    @FXML
    private Rectangle R_account;
    @FXML
    private Text accountText;
    @FXML
    private ImageView Icon_account;
    @FXML
    private Rectangle R_setting;
    @FXML
    private Text settingText;
    @FXML
    private ImageView Icon_setting;
    @FXML
    private Rectangle R_logout;
    @FXML
    private Text logoutText;
    @FXML
    private ImageView Icon_logout;


    Node[] practice = {R_practice, practiceText, Icon_practice};
    Node[] manage = {R_manage, manageText, Icon_manage};
    Node[] account = {R_account, accountText, Icon_account};
    Node[] setting = {R_setting, settingText, Icon_setting};
    Node[] logout = {R_logout, logoutText, Icon_logout};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myPracticeGroup.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            OnHover(event, R_practice, practiceText, Icon_practice);
        });
        myPracticeGroup.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            OutHover(event, R_practice, practiceText, Icon_practice);
        });

        myPracticeGroup.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                switchTo(event,"practiceH.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });



        MyLogoutGroup.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            OnHover(event, R_logout, logoutText, Icon_logout);
        });
        MyLogoutGroup.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            OutHover(event, R_logout, logoutText, Icon_logout);
        });


        MySettingGroup.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            OnHover(event, R_setting, settingText, Icon_setting);
        });
        MySettingGroup.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            OutHover(event, R_setting, settingText, Icon_setting);
        });

        MyAccountGroup.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            OnHover(event, R_account, accountText, Icon_account);
        });
        MyAccountGroup.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            OutHover(event, R_account, accountText, Icon_account);
        });

        myManageGroup.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            OnHover(event, R_manage, manageText, Icon_manage );
        });
        myManageGroup.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            OutHover(event, R_manage, manageText, Icon_manage);
        });

        myManageGroup.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                switchTo(event,"manage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });



    }

    public void OnHover(MouseEvent event, Rectangle rectangle, Text text, ImageView imageView) {
        rectangle.setStyle("-fx-opacity: 1;");
        text.setStyle("-fx-fill: #551FFF;");
        imageView.setStyle("-fx-opacity: 1;");
    }

    public void OutHover(MouseEvent event, Rectangle rectangle, Text text, ImageView imageView) {
        rectangle.setStyle("-fx-opacity: 0;");
        text.setStyle("");
        imageView.setStyle("-fx-opacity: 0;");
    }

    public void switchTo(Event event, String target) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(target)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("index.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }




}

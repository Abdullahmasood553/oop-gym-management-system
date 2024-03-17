package com.example.gms;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminView {
    public static void showAdminView(Stage stage) {
        stage.setTitle("Gym Management Detail Screen");

        StackPane root = new StackPane();
        root.getStyleClass().add("admin-detail");

        HBox buttonBox = new HBox();
        buttonBox.getStyleClass().add("button-box");

        Button registerUserDetailButton = new Button("Customer Detail");
        Button viewAdminDetailButton = new Button("Trainer Detail");

        registerUserDetailButton.setOnAction(e -> {

        });

        viewAdminDetailButton.setOnAction(e -> {

        });

        registerUserDetailButton.getStyleClass().add("button");
        viewAdminDetailButton.getStyleClass().add("button");

        buttonBox.getChildren().addAll(registerUserDetailButton, viewAdminDetailButton);
        root.getChildren().add(buttonBox);

        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(AdminView.class.getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}

package com.example.gms;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Gym Management System");

        StackPane root = new StackPane();
        root.getStyleClass().add("root");

        HBox buttonBox = new HBox();
        buttonBox.getStyleClass().add("button-box");

        Button registerUserDetailButton = new Button("Create Event");
        Button viewAdminDetailButton = new Button("Admin Login");

        registerUserDetailButton.setOnAction(e -> {
            MainScreen mainScreen = new MainScreen();
            try {
                mainScreen.start(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        viewAdminDetailButton.setOnAction(e -> {
            // Handle view admin detail button action
        });

        registerUserDetailButton.getStyleClass().add("button");
        viewAdminDetailButton.getStyleClass().add("button");

        buttonBox.getChildren().addAll(registerUserDetailButton, viewAdminDetailButton);
        root.getChildren().add(buttonBox);

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

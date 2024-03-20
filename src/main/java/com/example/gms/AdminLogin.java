package com.example.gms;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminLogin {

    public static void loginScreen(Stage stage) {
        stage.setTitle("Admin Login");

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setId("login-button");

        Label messageLabel = new Label();

        GridPane grid = new GridPane();
        grid.setId("grid-pane");
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.addRow(1, emailLabel, emailField);
        grid.addRow(2, passwordLabel, passwordField);
        grid.add(loginButton, 1, 3);
        grid.add(messageLabel, 1, 4);

        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (isValidCredentials(email, password)) {
                try {
                    AdminView.showAdminView(stage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // Show error message
                messageLabel.setText("Invalid credentials. Please try again.");
            }
        });

        Scene scene = new Scene(grid, 350, 250);
        scene.getStylesheets().add(AdminLogin.class.getResource("/styles.css").toExternalForm());


        stage.setScene(scene);
        stage.show();
    }

    private static boolean isValidCredentials(String email, String password) {
        return email.equals("admin@gmail.com") && password.equals("123456");
    }
}

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

        // Create form components
        Label headingLabel = new Label("Admin Login");
        headingLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create form components
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #4CAF50;" +
                " -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold; -fx-padding: 8 14;");


        Label messageLabel = new Label();

        // Add components to layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.addRow(0, headingLabel);
        GridPane.setColumnSpan(headingLabel, 2);
        GridPane.setMargin(headingLabel, new Insets(0, 0, 20, 0));
        grid.addRow(1, emailLabel, emailField);
        grid.addRow(2, passwordLabel, passwordField);
        grid.add(loginButton, 1, 3);
        grid.add(messageLabel, 1, 4);

        // Login action
        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (isValidCredentials(email, password)) {
                try {
//                    CustomerDetail.displayCustomerDetail(stage);
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
        stage.setScene(scene);
        stage.show();
    }

    // Method to check if credentials are valid
    private static boolean isValidCredentials(String email, String password) {
        return email.equals("admin@gmail.com") && password.equals("123456");
    }
}

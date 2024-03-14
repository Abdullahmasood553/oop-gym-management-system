package com.example.gms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {

    private BorderPane root;
    private CustomerForm customerForm;
    private TrainerForm trainerForm;
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Gym Management App");

        // Sidebar
        VBox sidebar = new VBox();
        sidebar.setStyle("-fx-background-color: #333;");
        sidebar.setMinWidth(200);

        Button customersButton = new Button("Customers");
        Button trainersButton = new Button("Trainers");

        customersButton.getStyleClass().add("sidebar-button");
        trainersButton.getStyleClass().add("sidebar-button");

        customersButton.setOnAction(e -> showCustomerForm());
        trainersButton.setOnAction(e -> showTrainerForm());

        sidebar.getChildren().addAll(customersButton, trainersButton);

        BorderPane sidebarContent = new BorderPane();
        sidebarContent.setCenter(sidebar);

        // Main Content
        customerForm = new CustomerForm();
        trainerForm = new TrainerForm();

        // Initially, show the customer form
        root = new BorderPane();
        root.setLeft(sidebarContent);
        root.setCenter(customerForm);

        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    private void showCustomerForm() {
        root.setCenter(customerForm);
    }

    private void showTrainerForm() {
        root.setCenter(trainerForm);
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.gms;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Sidebar extends VBox {
    private BorderPane root;
    private CustomerForm customerForm;
    private TrainerForm trainerForm;

    public Sidebar(BorderPane root, CustomerForm customerForm, TrainerForm trainerForm) {
        this.root = root;
        this.customerForm = customerForm;
        this.trainerForm = trainerForm;
        createSidebar();
    }

    private void createSidebar() {
        this.getStyleClass().add("sidebar");
        this.getStyleClass().add("sidebar-button-box");


        Button customersButton = new Button("Customers");
        Button trainersButton = new Button("Trainers");
        Button backButton = new Button("Back");


        customersButton.getStyleClass().addAll("sidebar-button", "list-item");
        trainersButton.getStyleClass().addAll("sidebar-button", "list-item");
        backButton.getStyleClass().addAll("sidebar-button", "list-item");


        customersButton.setOnAction(e -> showCustomerForm());
        trainersButton.setOnAction(e -> showTrainerForm());
        backButton.setOnAction(e -> {

            Stage currentStage = (Stage) backButton.getScene().getWindow();
            currentStage.close();

            HelloApplication helloApplication = new HelloApplication();
            try {
                helloApplication.start(new Stage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        VBox.setMargin(customersButton, new javafx.geometry.Insets(10, 0, 0, 0));
        VBox.setMargin(trainersButton, new javafx.geometry.Insets(10, 0, 0, 0));
        VBox.setMargin(backButton, new javafx.geometry.Insets(10, 0, 0, 0));
        this.getChildren().addAll(customersButton, trainersButton, backButton);
    }

    private void showCustomerForm() {
        root.setCenter(customerForm);
    }

    private void showTrainerForm() {
        root.setCenter(trainerForm);
    }
}

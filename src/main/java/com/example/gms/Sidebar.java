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
        // Add a CSS class to the VBox containing buttons
        this.getStyleClass().add("sidebar-button-box");


        Button customersButton = new Button("Customers");
        Button trainersButton = new Button("Trainers");
        // Button customerDetailButton = new Button("Customer Detail");

        customersButton.getStyleClass().addAll("sidebar-button", "list-item");
        trainersButton.getStyleClass().addAll("sidebar-button", "list-item");
//        customerDetailButton.getStyleClass().addAll("sidebar-button", "list-item");

        customersButton.setOnAction(e -> showCustomerForm());
        trainersButton.setOnAction(e -> showTrainerForm());
//        customerDetailButton.setOnAction(e -> {
//            try {
//                CustomerDetail.displayCustomerDetail(new Stage());
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        });

        VBox.setMargin(customersButton, new javafx.geometry.Insets(10, 0, 0, 0));
        VBox.setMargin(trainersButton, new javafx.geometry.Insets(10, 0, 0, 0));
//        VBox.setMargin(customerDetailButton, new javafx.geometry.Insets(10, 0, 0, 0));

//        this.getChildren().addAll(customersButton, trainersButton, customerDetailButton);
        this.getChildren().addAll(customersButton, trainersButton);
    }

    private void showCustomerForm() {
        root.setCenter(customerForm);
    }

    private void showTrainerForm() {
        root.setCenter(trainerForm);
    }
}

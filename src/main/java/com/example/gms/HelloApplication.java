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
        sidebar.getStyleClass().add("sidebar");

        Button customersButton = new Button("Customers");
        Button trainersButton = new Button("Trainers");
        Button customerDetailButton = new Button("Customer Detail");

        customersButton.getStyleClass().addAll("sidebar-button", "list-item");
        trainersButton.getStyleClass().addAll("sidebar-button", "list-item");

        customersButton.setOnAction(e -> showCustomerForm());
        trainersButton.setOnAction(e -> showTrainerForm());
        customerDetailButton.setOnAction(e -> {
            try {
                CustomerDetail.displayCustomerDetail(new Stage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });



        VBox.setMargin(customersButton, new javafx.geometry.Insets(10, 0, 0, 0));
        VBox.setMargin(trainersButton, new javafx.geometry.Insets(10, 0, 0, 0));

        sidebar.getChildren().addAll(customersButton, trainersButton, customerDetailButton);

        BorderPane sidebarContent = new BorderPane();
        sidebarContent.setCenter(sidebar);

        // Main Content
        customerForm = new CustomerForm();
        trainerForm = new TrainerForm();


        // Initially, show the customer form
        root = new BorderPane();
        root.setLeft(sidebarContent);
        root.setCenter(customerForm);

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setScene(scene);
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

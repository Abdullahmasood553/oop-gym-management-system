package com.example.gms;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen {
    private BorderPane root;
    private CustomerForm customerForm;
    private TrainerForm trainerForm;
    private Sidebar sidebar;

    public void start(Stage stage) throws IOException {
        stage.setTitle("Gym Management App");

        customerForm = new CustomerForm();
        trainerForm = new TrainerForm();

        root = new BorderPane();
        sidebar = new Sidebar(root, customerForm, trainerForm);
        root.setLeft(sidebar);
        showCustomerForm();

        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    private void showCustomerForm() {
        root.setCenter(customerForm);
    }
}

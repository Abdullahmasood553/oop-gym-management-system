package com.example.gms;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Sidebar {

    public BorderPane getContent() {
        VBox sidebar = new VBox();
        sidebar.setStyle("-fx-background-color: #333;");
        sidebar.setMinWidth(200);

        Button customersButton = new Button("Customers");
        Button trainersButton = new Button("Trainers");

        customersButton.getStyleClass().addAll("sidebar-link", "list-item");
        trainersButton.getStyleClass().addAll("sidebar-link", "list-item");

        sidebar.getChildren().addAll(customersButton, trainersButton);

        BorderPane sidebarContent = new BorderPane();
        sidebarContent.setCenter(sidebar);

        sidebarContent.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        return sidebarContent;
    }
}

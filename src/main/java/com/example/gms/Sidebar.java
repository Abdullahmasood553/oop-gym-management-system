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
        Button customerDetailButton = new Button("Customer Detail");

        customersButton.getStyleClass().add("sidebar-button");
        trainersButton.getStyleClass().add("sidebar-button");

        sidebar.getChildren().addAll(customersButton, trainersButton, customerDetailButton);

        BorderPane sidebarContent = new BorderPane();
        sidebarContent.setCenter(sidebar);

        return sidebarContent;
    }
}

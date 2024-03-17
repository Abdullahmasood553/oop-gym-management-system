package com.example.gms;

import com.example.gms.models.Customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetail {

    public static void displayCustomerDetail(Stage primaryStage) throws IOException {
        List<Customer> customers = readCustomersFromFile("customers.txt");

        // Create table columns
        TableColumn<Customer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Customer, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Customer, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Customer, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Create TableView
        TableView<Customer> tableView = new TableView<>();
        tableView.getColumns().addAll(nameColumn, ageColumn, genderColumn, emailColumn);

        // Add data to the TableView
        ObservableList<Customer> data = FXCollections.observableArrayList(customers);
        tableView.setItems(data);


        // Set up the scene and show the stage
        Scene scene = new Scene(tableView, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer Details");
        primaryStage.show();
    }

    private static List<Customer> readCustomersFromFile(String filename) throws IOException {
        List<Customer> customers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String gender = parts[2];
                String address = parts[3];
                String email = parts[4];
                String phoneNumber = parts[5];
                String membershipType = parts[6];
                String startDate = parts[7];

                Customer customer = new Customer(name, age, gender, address, email, phoneNumber, membershipType, startDate);
                customers.add(customer);
            }
        }

        reader.close();
        return customers;
    }
}

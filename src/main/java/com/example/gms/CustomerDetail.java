package com.example.gms;

import com.example.gms.models.Customer;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetail {

    public static void displayCustomerDetail(Stage primaryStage) throws IOException {
        List<Customer> customers = readCustomersFromFile("customers.txt");
        List<HBox> customerCards = createCustomerCards(customers);

        HBox root = new HBox(10); // Horizontal layout with spacing of 10
        root.getChildren().addAll(customerCards);

        Scene scene = new Scene(root, 800, 600);
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
            if (parts.length == 8) { // Assuming each line has 8 fields
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

    private static List<HBox> createCustomerCards(List<Customer> customers) {
        List<HBox> customerCards = new ArrayList<>();

        for (Customer customer : customers) {
            Label nameLabel = new Label("Name: " + customer.getName());
            Label ageLabel = new Label("Age: " + customer.getAge());
            Label genderLabel = new Label("Gender: " + customer.getGender());
            Label emailLabel = new Label("Email: " + customer.getEmail());

            HBox card = new HBox(10); // Horizontal layout with spacing of 10
            card.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px; -fx-border-radius: 5px; -fx-border-color: #ccc;");
            card.getChildren().addAll(nameLabel, ageLabel, genderLabel, emailLabel);

            customerCards.add(card);
        }

        return customerCards;
    }
}

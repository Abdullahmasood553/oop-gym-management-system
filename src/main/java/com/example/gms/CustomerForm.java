package com.example.gms;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CustomerForm extends GridPane {

    private TextField nameField;
    private TextField ageField;
    private ComboBox<String> genderFieldComboBox;
    private TextField addressField;
    private TextField emailField;
    private TextField phoneNumberField;
    private ComboBox<String> membershipTypeComboBox;
    private DatePicker startDatePicker;
    private TextField priceField;
    private Label statusLabel;

    public CustomerForm() {
        super();
        this.getStyleClass().add("customer-form");
        setPadding(new Insets(50));
        setHgap(20);
        setVgap(20);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(40);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(60);
        getColumnConstraints().addAll(column1, column2);

        Label nameLabel = new Label("Full Name:");
        nameField = new TextField();
        nameField.getStyleClass().add("text-field");

        Label ageLabel = new Label("Age:");
        ageField = new TextField();
        ageField.getStyleClass().add("text-field");


        Label genderLabel = new Label("Gender:");
        genderFieldComboBox = new ComboBox<>();
        genderFieldComboBox.getItems().addAll("Male", "Female");
        genderFieldComboBox.getStyleClass().add("combo-box");
        genderFieldComboBox.setMaxWidth(Double.MAX_VALUE);


        Label addressLabel = new Label("Address:");
        addressField = new TextField();
        addressField.getStyleClass().add("text-field");

        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        emailField.getStyleClass().add("text-field");

        Label phoneNumberLabel = new Label("Phone Number:");
        phoneNumberField = new TextField();
        phoneNumberField.getStyleClass().add("text-field");

        Label membershipTypeLabel = new Label("Membership Type:");
        membershipTypeComboBox = new ComboBox<>();
        membershipTypeComboBox.getItems().addAll("Monthly", "Annual", "Lifetime");
        membershipTypeComboBox.getStyleClass().add("combo-box");
        membershipTypeComboBox.setMaxWidth(Double.MAX_VALUE);
        membershipTypeComboBox.setOnAction(e -> updatePrice());

        Label startDateLabel = new Label("Membership Start Date:");
        startDatePicker = new DatePicker();
        startDatePicker.setMaxWidth(Double.MAX_VALUE);
        startDatePicker.setValue(LocalDate.now());

        Label priceLabel = new Label("Price:");
        priceField = new TextField();
        priceField.setEditable(false);

        Button submitButton = new Button("Submit");
        submitButton.getStyleClass().add("submit-button");
        submitButton.setOnAction(e -> saveCustomerData());

        addRow(0, nameLabel, nameField);
        addRow(1, ageLabel, ageField);
        addRow(2, genderLabel, genderFieldComboBox);
        addRow(3, addressLabel, addressField);
        addRow(4, emailLabel, emailField);
        addRow(5, phoneNumberLabel, phoneNumberField);
        addRow(6, membershipTypeLabel, membershipTypeComboBox);
        addRow(7, startDateLabel, startDatePicker);
        addRow(8, priceLabel, priceField);
        addRow(9, submitButton);

        statusLabel = new Label();
        add(statusLabel, 0, 10, 2, 1);

        this.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    }

    private void updatePrice() {
        String membershipType = membershipTypeComboBox.getValue();
        if (membershipType != null) {
            double price = 0;
            switch (membershipType) {
                case "Monthly":
                    price = 50;
                    break;
                case "Annual":
                    price = 1500;
                    break;
                case "Lifetime":
                    price = 8000;
                    break;
            }
            priceField.setText(String.valueOf(price));
        }
    }


    private void saveCustomerData() {
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = genderFieldComboBox.getValue();
        String address = addressField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String membershipType = membershipTypeComboBox.getValue();
        LocalDate startDate = startDatePicker.getValue();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt", true))) {
            if (!name.isEmpty() && !age.isEmpty() && !gender.isEmpty() && !address.isEmpty() &&
                    !email.isEmpty() && !phoneNumber.isEmpty() && membershipType != null && startDate != null) {
                writer.write(name + "," + age + "," + gender + "," + address + "," +
                        email + "," + phoneNumber + "," + membershipType + "," + startDate + "\n");


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Customer data added successfully.");
                alert.showAndWait();

                nameField.clear();
                ageField.clear();
                genderFieldComboBox.setValue(null);
                addressField.clear();
                emailField.clear();
                phoneNumberField.clear();
                membershipTypeComboBox.setValue(null);
                startDatePicker.setValue(null);
                priceField.clear();
            } else {
                statusLabel.setText("Please fill in all fields.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            statusLabel.setText("Error: " + ex.getMessage());
        }
    }
}

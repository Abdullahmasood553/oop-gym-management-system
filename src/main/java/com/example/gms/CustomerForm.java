package com.example.gms;

import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CustomerForm extends GridPane {

    private TextField nameField;
    private TextField ageField;
    private TextField genderField;
    private TextField addressField;
    private TextField emailField;
    private TextField phoneNumberField;
    private ComboBox<String> membershipTypeComboBox;
    private DatePicker startDatePicker;
    private Label statusLabel;

    public CustomerForm() {
        super();
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        // Define column constraints
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
        genderField = new TextField();
        genderField.getStyleClass().add("text-field");

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
        membershipTypeComboBox.setMaxWidth(Double.MAX_VALUE); // Make the ComboBox full width

        Label startDateLabel = new Label("Membership Start Date:");
        startDatePicker = new DatePicker(); // Use DatePicker for date selection
        startDatePicker.setMaxWidth(Double.MAX_VALUE);
        startDatePicker.setValue(LocalDate.now()); // Set default value to today's date

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> saveCustomerData());

        // Add labels and fields to the grid
        addRow(0, nameLabel, nameField);
        addRow(1, ageLabel, ageField);
        addRow(2, genderLabel, genderField);
        addRow(3, addressLabel, addressField);
        addRow(4, emailLabel, emailField);
        addRow(5, phoneNumberLabel, phoneNumberField);
        addRow(6, membershipTypeLabel, membershipTypeComboBox);
        addRow(7, startDateLabel, startDatePicker);
        addRow(8, submitButton);

        // Add status label
        statusLabel = new Label();
        add(statusLabel, 0, 9, 2, 1); // Span over two columns

        // Apply styles
        this.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    }

    private void saveCustomerData() {
        // Get values from fields
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = genderField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String membershipType = membershipTypeComboBox.getValue();
        LocalDate startDate = startDatePicker.getValue();

        // Append customer data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt", true))) {
            // Validate if all fields are filled
            if (!name.isEmpty() && !age.isEmpty() && !gender.isEmpty() && !address.isEmpty() &&
                    !email.isEmpty() && !phoneNumber.isEmpty() && membershipType != null && startDate != null) {
                writer.write(name + "," + age + "," + gender + "," + address + "," +
                        email + "," + phoneNumber + "," + membershipType + "," + startDate + "\n");

                // Show success message
                statusLabel.setText("Customer data added successfully.");

                // Clear text fields after submission
                nameField.clear();
                ageField.clear();
                genderField.clear();
                addressField.clear();
                emailField.clear();
                phoneNumberField.clear();
                membershipTypeComboBox.setValue(null);
                startDatePicker.setValue(null);
            } else {
                // Show error message if any field is empty
                statusLabel.setText("Please fill in all fields.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            statusLabel.setText("Error: " + ex.getMessage());
        }
    }
}

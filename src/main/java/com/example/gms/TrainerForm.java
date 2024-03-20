package com.example.gms;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class TrainerForm extends GridPane {

    final private TextField nameField;
    final private TextField ageField;
    final private ComboBox<String> genderComboBox;
    final private TextField addressField;
    final private TextField emailField;
    final private TextField phoneNumberField;
    final private TextField specializationField;
    final private ComboBox<String> experienceLevelComboBox;
    final private TextField certificationField;
    final private TextField hourlyRateField;
    final private Label statusLabel;

    public TrainerForm() {
        super();
        this.getStyleClass().add("trainer-form");
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
        genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female");
        genderComboBox.getStyleClass().add("combo-box");
        genderComboBox.setMaxWidth(Double.MAX_VALUE);

        Label addressLabel = new Label("Address:");
        addressField = new TextField();
        addressField.getStyleClass().add("text-field");

        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        emailField.getStyleClass().add("text-field");

        Label phoneNumberLabel = new Label("Phone Number:");
        phoneNumberField = new TextField();
        phoneNumberField.getStyleClass().add("text-field");

        Label specializationLabel = new Label("Specialization:");
        specializationField = new TextField();
        specializationField.getStyleClass().add("text-field");

        Label experienceLevelLabel = new Label("Experience Level:");
        experienceLevelComboBox = new ComboBox<>();
        experienceLevelComboBox.getItems().addAll("Beginner", "Intermediate", "Advanced");
        experienceLevelComboBox.getStyleClass().add("combo-box");
        experienceLevelComboBox.setMaxWidth(Double.MAX_VALUE);

        Label certificationLabel = new Label("Certification:");
        certificationField = new TextField();
        certificationField.getStyleClass().add("text-field");

        Label hourlyRateLabel = new Label("Hourly Rate:");
        hourlyRateField = new TextField();
        hourlyRateField.getStyleClass().add("text-field");

        Button submitButton = new Button("Submit");
        submitButton.getStyleClass().add("submit-button");
        submitButton.setOnAction(e -> saveTrainerData());

        addRow(0, nameLabel, nameField);
        addRow(1, ageLabel, ageField);
        addRow(2, genderLabel, genderComboBox);
        addRow(3, addressLabel, addressField);
        addRow(4, emailLabel, emailField);
        addRow(5, phoneNumberLabel, phoneNumberField);
        addRow(6, specializationLabel, specializationField);
        addRow(7, experienceLevelLabel, experienceLevelComboBox);
        addRow(8, certificationLabel, certificationField);
        addRow(9, hourlyRateLabel, hourlyRateField);
        addRow(10, submitButton);

        // Add status label
        statusLabel = new Label();
        add(statusLabel, 0, 11, 2, 1); // Span over two columns

        // Apply styles
        this.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    }

    private void saveTrainerData() {
        String name = nameField.getText();
        String age = ageField.getText();
        String gender = genderComboBox.getValue();
        String address = addressField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String specialization = specializationField.getText();
        String experienceLevel = experienceLevelComboBox.getValue();
        String certification = certificationField.getText();
        String hourlyRate = hourlyRateField.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("trainers.txt", true))) {
            if (!name.isEmpty() && !age.isEmpty() && !gender.isEmpty() && !address.isEmpty() &&
                    !email.isEmpty() && !phoneNumber.isEmpty() && !specialization.isEmpty() &&
                    experienceLevel != null && !certification.isEmpty() && !hourlyRate.isEmpty()) {
                writer.write(name + "," + age + "," + gender + "," + address + "," +
                        email + "," + phoneNumber + "," + specialization + "," +
                        experienceLevel + "," + certification + "," + hourlyRate + "\n");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Trainer data added successfully.");
                alert.showAndWait();

                nameField.clear();
                ageField.clear();
                genderComboBox.setValue(null);
                addressField.clear();
                emailField.clear();
                phoneNumberField.clear();
                specializationField.clear();
                experienceLevelComboBox.setValue(null);
                certificationField.clear();
                hourlyRateField.clear();
            } else {
                statusLabel.setText("Please fill in all fields.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            statusLabel.setText("Error: " + ex.getMessage());
        }
    }
}

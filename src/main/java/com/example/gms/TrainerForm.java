package com.example.gms;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class TrainerForm extends GridPane {

    public TrainerForm() {
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
        TextField nameField = new TextField();
        nameField.getStyleClass().add("text-field");

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        ageField.getStyleClass().add("text-field");

        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField();
        genderField.getStyleClass().add("text-field");

        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        addressField.getStyleClass().add("text-field");

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.getStyleClass().add("text-field");

        Label phoneNumberLabel = new Label("Phone Number:");
        TextField phoneNumberField = new TextField();
        phoneNumberField.getStyleClass().add("text-field");

        Label qualificationLabel = new Label("Qualification:");
        TextField qualificationField = new TextField();
        qualificationLabel.getStyleClass().add("text-field");

        Label experienceLabel = new Label("Experience (in years):");
        TextField experienceField = new TextField();
        experienceField.getStyleClass().add("text-field");

        Label specializationLabel = new Label("Specialization:");
        TextField specializationField = new TextField();
        specializationLabel.getStyleClass().add("text-field");

        // Add labels and fields to the grid
        addRow(0, nameLabel, nameField);
        addRow(1, ageLabel, ageField);
        addRow(2, genderLabel, genderField);
        addRow(3, addressLabel, addressField);
        addRow(4, emailLabel, emailField);
        addRow(5, phoneNumberLabel, phoneNumberField);
        addRow(6, qualificationLabel, qualificationField);
        addRow(7, experienceLabel, experienceField);
        addRow(8, specializationLabel, specializationField);


        // Apply styles
        this.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
    }
}

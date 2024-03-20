package com.example.gms;

import com.example.gms.models.Trainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainerDetail {

    public static void displayTrainerDetail(Stage primaryStage) throws IOException {
        List<Trainer> trainers = readTrainersFromFile("trainers.txt");

        TableColumn<Trainer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Trainer, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Trainer, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Trainer, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Trainer, String> phoneNumberColumn = new TableColumn<>("Phone No");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Trainer, String> specializationColumn = new TableColumn<>("Specialization");
        specializationColumn.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        TableView<Trainer> tableView = new TableView<>();
        tableView.getColumns().addAll(nameColumn, ageColumn, genderColumn, emailColumn, specializationColumn, phoneNumberColumn);

        tableView.setStyle("-fx-background-color: #f0f0f0;");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ObservableList<Trainer> data = FXCollections.observableArrayList(trainers);
        tableView.setItems(data);

        StackPane root = new StackPane(tableView);
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Trainer Details");
        primaryStage.show();
    }

    private static List<Trainer> readTrainersFromFile(String filename) throws IOException {
        List<Trainer> trainers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 10) {
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String gender = parts[2];
                String address = parts[3];
                String email = parts[4];
                String phoneNumber = parts[5];
                String specialization = parts[6];
                String experienceLevel = parts[7];
                String certification = parts[8];
                double hourlyRate = Double.parseDouble(parts[9]);

                Trainer trainer = new Trainer(name, age, gender, address, email, phoneNumber, specialization, experienceLevel, certification, hourlyRate);
                trainers.add(trainer);
            }
        }

        reader.close();
        return trainers;
    }
}
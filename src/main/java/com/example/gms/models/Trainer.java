package com.example.gms.models;

public class Trainer {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String email;
    private String phoneNumber;
    private String specialization;
    private String experienceLevel;
    private String certification;
    private double hourlyRate;

    // Constructor
    public Trainer(String name, int age, String gender, String address, String email, String phoneNumber, String specialization, String experienceLevel, String certification, double hourlyRate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.experienceLevel = experienceLevel;
        this.certification = certification;
        this.hourlyRate = hourlyRate;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public String getCertification() {
        return certification;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
package com.example.gms.models;

public class Customer {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String email;
    private String phoneNumber;
    private String membershipType;
    private String startDate;

    public Customer(String name, int age, String gender, String address, String email, String phoneNumber, String membershipType, String startDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipType = membershipType;
        this.startDate = startDate;
    }


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

    public String getMembershipType() {
        return membershipType;
    }

    public String getStartDate() {
        return startDate;
    }
}

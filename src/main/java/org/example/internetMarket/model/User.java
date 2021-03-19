package org.example.internetMarket.model;

import java.time.LocalDate;

public class User {
    private int user_id;
    private String name;
    private String address;
    private String email;
    private String gender;
    private LocalDate date_Of_Birth;

    public User() {
    }

    public User(int user_id, String name, String address, String email, String gender, LocalDate date_Of_Birth) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.date_Of_Birth = date_Of_Birth;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return date_Of_Birth;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDate_Of_Birth(LocalDate date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + date_Of_Birth +
                '}';
    }
}

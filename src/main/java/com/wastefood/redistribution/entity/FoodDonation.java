package com.wastefood.redistribution.entity;

import jakarta.persistence.*;

@Entity
public class FoodDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;
    private int quantity;
    private String location;
    private String expiryTime;
    private String status;

    // Constructors
    public FoodDonation() {}

    public FoodDonation(String foodName, int quantity, String location, String expiryTime, String status) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.location = location;
        this.expiryTime = expiryTime;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getExpiryTime() { return expiryTime; }
    public void setExpiryTime(String expiryTime) { this.expiryTime = expiryTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
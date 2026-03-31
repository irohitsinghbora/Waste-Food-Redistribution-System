package com.wastefood.redistribution.controller;

import com.wastefood.redistribution.entity.FoodDonation;
import com.wastefood.redistribution.service.FoodDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class FoodDonationController {

    @Autowired
    private FoodDonationService service;

    @PostMapping("/add")
    public FoodDonation addDonation(@RequestBody FoodDonation donation) {
        return service.addDonation(donation);
    }

    @GetMapping("/all")
    public List<FoodDonation> getAllDonations() {
        return service.getAllDonations();
    }

    @PutMapping("/accept/{id}")
    public FoodDonation acceptDonation(@PathVariable Long id) {
        return service.acceptDonation(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDonation(@PathVariable Long id) {
        service.deleteDonation(id);
    }
}
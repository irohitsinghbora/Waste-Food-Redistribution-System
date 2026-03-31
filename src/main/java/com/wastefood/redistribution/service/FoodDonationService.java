package com.wastefood.redistribution.service;

import com.wastefood.redistribution.entity.FoodDonation;
import com.wastefood.redistribution.repository.FoodDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodDonationService {

    @Autowired
    private FoodDonationRepository repository;

    public FoodDonation addDonation(FoodDonation donation) {
        donation.setStatus("AVAILABLE");
        return repository.save(donation);
    }

    public List<FoodDonation> getAllDonations() {
        return repository.findAll();
    }

    public FoodDonation acceptDonation(Long id) {
        FoodDonation donation = repository.findById(id).orElse(null);
        if (donation != null) {
            donation.setStatus("ACCEPTED");
            return repository.save(donation);
        }
        return null;
    }

    public void deleteDonation(Long id) {
        repository.deleteById(id);
    }
}
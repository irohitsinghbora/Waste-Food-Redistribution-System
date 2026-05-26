package com.wastefood.redistribution.repository;

import com.wastefood.redistribution.entity.FoodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDonationRepository extends JpaRepository<FoodDonation, Long> {
}
package com.sneivlp.sneivlpidentityservice.repository;

import com.sneivlp.sneivlpidentityservice.entity.CitizenBiometric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenBiometricRepository
        extends JpaRepository<CitizenBiometric, Long> {

    List<CitizenBiometric> findByCitizen_Id(Long citizenId);

    List<CitizenBiometric> findByVerified(Boolean verified);
}

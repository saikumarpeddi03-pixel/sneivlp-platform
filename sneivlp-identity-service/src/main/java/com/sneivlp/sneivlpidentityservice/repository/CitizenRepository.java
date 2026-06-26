package com.sneivlp.sneivlpidentityservice.repository;

import com.sneivlp.sneivlpidentityservice.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepository
        extends JpaRepository<Citizen, Long> {

    Optional<Citizen> findByCitizenId(String citizenId);

    Optional<Citizen> findByAadhaarReference(String aadhaarReference);

    Optional<Citizen> findByMobileNumber(String mobileNumber);

    Optional<Citizen> findByEmail(String email);

    boolean existsByCitizenId(String citizenId);

    boolean existsByAadhaarReference(String aadhaarReference);

    boolean existsByMobileNumber(String mobileNumber);

    boolean existsByEmail(String email);
}

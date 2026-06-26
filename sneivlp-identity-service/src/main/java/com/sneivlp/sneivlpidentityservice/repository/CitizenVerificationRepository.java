package com.sneivlp.sneivlpidentityservice.repository;

import com.sneivlpcommon.enums.VerificationStatus;
import com.sneivlp.sneivlpidentityservice.entity.CitizenVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenVerificationRepository
        extends JpaRepository<CitizenVerification, Long> {

    List<CitizenVerification> findByVerificationStatus(
            VerificationStatus verificationStatus);
}

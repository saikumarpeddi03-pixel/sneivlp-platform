package com.sneivlp.sneivlpidentityservice.repository;

import com.sneivlp.sneivlpidentityservice.entity.CitizenDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenDocumentRepository
        extends JpaRepository<CitizenDocument, Long> {

    List<CitizenDocument> findByCitizen_Id(Long citizenId);

    List<CitizenDocument> findByVerified(Boolean verified);

    List<CitizenDocument> findByDocumentType(String documentType);
}

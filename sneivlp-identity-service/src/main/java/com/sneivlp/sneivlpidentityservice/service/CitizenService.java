package com.sneivlp.sneivlpidentityservice.service;

import com.sneivlp.sneivlpidentityservice.dto.request.CreateCitizenRequest;
import com.sneivlp.sneivlpidentityservice.dto.request.UpdateCitizenRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.CitizenResponse;

import java.util.List;

public interface CitizenService {

    CitizenResponse createCitizen(
            CreateCitizenRequest request);

    CitizenResponse getCitizenById(
            Long citizenId);

    CitizenResponse getCitizenByCitizenId(
            String citizenId);

    List<CitizenResponse> getAllCitizens();

    CitizenResponse updateCitizen(
            Long citizenId,
            UpdateCitizenRequest request);

    void deleteCitizen(
            Long citizenId);
}

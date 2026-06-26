package com.sneivlp.sneivlpidentityservice.service.impl;

import com.sneivlp.sneivlpidentityservice.dto.request.CreateCitizenRequest;
import com.sneivlp.sneivlpidentityservice.dto.request.UpdateCitizenRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.CitizenResponse;
import com.sneivlp.sneivlpidentityservice.entity.Citizen;
import com.sneivlp.sneivlpidentityservice.mapper.CitizenMapper;
import com.sneivlp.sneivlpidentityservice.repository.CitizenRepository;
import com.sneivlp.sneivlpidentityservice.service.CitizenService;
import com.sneivlpcommon.enums.CitizenStatus;
import com.sneivlpcommon.enums.VerificationStatus;
import com.sneivlpcommon.exceptions.BusinessException;
import com.sneivlpcommon.exceptions.ResourceNotFoundException;
import com.sneivlpcommon.util.IdGeneratorUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;
    private final CitizenMapper citizenMapper;

    @Override
    public CitizenResponse createCitizen(CreateCitizenRequest request) {

        validateCitizen(request);

        Citizen citizen = citizenMapper.toEntity(request);

        citizen.setCitizenId(IdGeneratorUtil.generateCitizenId());

        citizen.setStatus(CitizenStatus.ACTIVE);

        citizen.setVerificationStatus(VerificationStatus.PENDING);

        Citizen savedCitizen = citizenRepository.save(citizen);

        return citizenMapper.toResponse(savedCitizen);
    }

    @Transactional
    public CitizenResponse getCitizenById(
            Long citizenId) {

        Citizen citizen =
                citizenRepository.findById(citizenId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Citizen not found"));

        return citizenMapper.toResponse(citizen);
    }

    @Transactional
    public CitizenResponse getCitizenByCitizenId(
            String citizenId) {

        Citizen citizen =
                citizenRepository.findByCitizenId(citizenId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Citizen not found"));

        return citizenMapper.toResponse(citizen);

    }

    @Transactional
    public List<CitizenResponse> getAllCitizens() {

        return citizenRepository.findAll()
                .stream()
                .map(citizenMapper::toResponse)
                .toList();
    }

    public CitizenResponse updateCitizen(
            Long citizenId,
            UpdateCitizenRequest request) {

        Citizen citizen =
                citizenRepository.findById(citizenId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Citizen not found"));

        citizen.setFirstName(request.getFirstName());
        citizen.setMiddleName(request.getMiddleName());
        citizen.setLastName(request.getLastName());
        citizen.setGender(request.getGender());
        citizen.setDateOfBirth(request.getDateOfBirth());
        citizen.setMobileNumber(request.getMobileNumber());
        citizen.setEmail(request.getEmail());

        Citizen updatedCitizen =
                citizenRepository.save(citizen);

        return citizenMapper.toResponse(updatedCitizen);
    }

    @Override
    public void deleteCitizen(
            Long citizenId) {

        Citizen citizen =
                citizenRepository.findById(citizenId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Citizen not found"));

        citizen.setIsDeleted(true);

        citizenRepository.save(citizen);
    }

    private void validateCitizen(
            CreateCitizenRequest request) {

        if (citizenRepository.existsByAadhaarReference(
                request.getAadhaarReference())) {

            throw new BusinessException(
                    "Citizen already exists with Aadhaar Reference");
        }

        if (citizenRepository.existsByMobileNumber(
                request.getMobileNumber())) {

            throw new BusinessException(
                    "Citizen already exists with Mobile Number");
        }

        if (request.getEmail() != null &&
                citizenRepository.existsByEmail(
                        request.getEmail())) {

            throw new BusinessException(
                    "Citizen already exists with Email");
        }
    }
}
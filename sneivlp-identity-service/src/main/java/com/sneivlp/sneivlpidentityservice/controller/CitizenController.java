package com.sneivlp.sneivlpidentityservice.controller;

import com.sneivlp.sneivlpidentityservice.dto.request.CreateCitizenRequest;
import com.sneivlp.sneivlpidentityservice.dto.request.UpdateCitizenRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.CitizenResponse;
import com.sneivlp.sneivlpidentityservice.mapper.CitizenMapper;
import com.sneivlp.sneivlpidentityservice.service.CitizenService;
import com.sneivlpcommon.response.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citizen")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SecurityRequirement(name = "Bearer Authentication")
public class CitizenController {

    private final CitizenService citizenService;

    @PostMapping
    public ResponseEntity<ApiResponse<CitizenResponse>> createCitizen(
            @Valid @RequestBody CreateCitizenRequest request) {

        CitizenResponse response = citizenService.createCitizen(request);

        ApiResponse<CitizenResponse> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Citizen created successfully");
        apiResponse.setData(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CitizenResponse>> getCitizenById(
            @PathVariable Long id) {

        CitizenResponse response = citizenService.getCitizenById(id);

        ApiResponse<CitizenResponse> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Citizen retrieved successfully");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/citizen-id/{citizenId}")
    public ResponseEntity<ApiResponse<CitizenResponse>> getCitizenByCitizenId(
            @PathVariable String citizenId) {

        CitizenResponse response =
                citizenService.getCitizenByCitizenId(citizenId);

        ApiResponse<CitizenResponse> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Citizen retrieved successfully");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CitizenResponse>>> getAllCitizens() {

        List<CitizenResponse> response =
                citizenService.getAllCitizens();

        ApiResponse<List<CitizenResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Citizens retrieved successfully");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CitizenResponse>> updateCitizen(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCitizenRequest request) {

        CitizenResponse response =
                citizenService.updateCitizen(id, request);

        ApiResponse<CitizenResponse> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Citizen updated successfully");
        apiResponse.setData(response);

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCitizen(
            @PathVariable Long id) {

        citizenService.deleteCitizen(id);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("Citizen deleted successfully");
        apiResponse.setData("Citizen deleted successfully");

        return ResponseEntity.ok(apiResponse);
    }
}

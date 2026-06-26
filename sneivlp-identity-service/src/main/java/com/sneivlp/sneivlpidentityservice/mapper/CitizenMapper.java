package com.sneivlp.sneivlpidentityservice.mapper;

import com.sneivlp.sneivlpidentityservice.dto.request.CreateCitizenRequest;
import com.sneivlp.sneivlpidentityservice.dto.response.CitizenResponse;
import com.sneivlp.sneivlpidentityservice.entity.Citizen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CitizenMapper {

    Citizen toEntity(CreateCitizenRequest request);

    CitizenResponse toResponse(Citizen citizen);
}

package com.sneivlpcommon.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseDTO {

    private Long id;

    private String createdBy;

    private LocalDateTime createdDate;

    private String updatedBy;

    private LocalDateTime updatedDate;

    private Boolean isActive;

    private Boolean isDeleted;
}

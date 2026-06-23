package com.sneivlpcommon.dto;

import lombok.Data;

@Data
public class SearchRequestDTO {

    private String keyword;

    private Integer page;

    private Integer size;

    private String sortBy;

    private String sortDirection;
}

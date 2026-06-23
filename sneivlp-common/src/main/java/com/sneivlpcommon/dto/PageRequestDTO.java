package com.sneivlpcommon.dto;

import lombok.Data;

@Data
public class PageRequestDTO {

    private int page = 0;

    private int size = 10;

    private String sortBy = "id";

    private String sortDirection = "ASC";
}

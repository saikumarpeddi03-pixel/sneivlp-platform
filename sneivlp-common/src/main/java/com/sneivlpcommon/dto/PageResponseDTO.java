package com.sneivlpcommon.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageResponseDTO<T> {

    private List<T> content;

    private long totalElements;

    private int totalPages;

    private int currentPage;

    private int pageSize;

    private boolean first;

    private boolean last;
}

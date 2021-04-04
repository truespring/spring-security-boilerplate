package com.mini2S.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsPagingDto {
    private int startPage;
    private int endPage;
    private int printPageSize;
    private int currentPage;
    private int requirePage;
    private int printListSize;
}

package com.krf.bs.domain.po.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryDto {
    private String name;
    private int pageNum;
    private int pageSize;
}

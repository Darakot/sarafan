package com.pethomeproject.sarafan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO для отображения комментов
 */
@Data
@AllArgsConstructor
public class MetaDto {
    private String title;
    private String description;
    private String cover;
}

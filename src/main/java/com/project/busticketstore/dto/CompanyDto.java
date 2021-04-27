package com.project.busticketstore.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyDto {
    @NotBlank
    private String name;
    private Boolean isActive;
}

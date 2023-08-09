package com.footvolley.controller.athlete.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AthleteRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String cpf;
}

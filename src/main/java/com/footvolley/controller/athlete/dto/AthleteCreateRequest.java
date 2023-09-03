package com.footvolley.controller.athlete.dto;

import com.footvolley.common.validator.constraints.CPF;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AthleteCreateRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @CPF(message = "CPF is invalid")
    private String cpf;
    @NotBlank(message = "Birth date is required")
    private String birthDate;
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @NotBlank(message = "Nickname is required")
    private String nickName;
}

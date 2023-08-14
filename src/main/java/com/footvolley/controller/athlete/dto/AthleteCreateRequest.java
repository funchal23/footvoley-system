package com.footvolley.controller.athlete.dto;

import com.footvolley.common.validator.constraints.CPF;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AthleteCreateRequest {
    private String name;
    @CPF
    private String cpf;
    private String birthDate;
    private String phoneNumber;
    private String nickName;
}

package com.footvolley.controller.athlete.dto;

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
    private String cpf;
    private String birthDate;
    private String phoneNumber;
    private String nickName;
}

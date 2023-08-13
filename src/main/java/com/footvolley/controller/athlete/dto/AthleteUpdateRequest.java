package com.footvolley.controller.athlete.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AthleteUpdateRequest {
    private String phoneNumber;
    private String nickName;
}

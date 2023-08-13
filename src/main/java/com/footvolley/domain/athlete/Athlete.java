package com.footvolley.domain.athlete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "AthleteDocument")
public class Athlete {
    @Id
    private String id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String phoneNumber;
    private String nickName;
}

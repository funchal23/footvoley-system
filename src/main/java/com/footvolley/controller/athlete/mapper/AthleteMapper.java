package com.footvolley.controller.athlete.mapper;

import com.footvolley.controller.athlete.dto.AthleteCreateRequest;
import com.footvolley.controller.athlete.dto.AthleteUpdateRequest;
import com.footvolley.domain.athlete.Athlete;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {java.time.LocalDate.class})
public interface AthleteMapper {

    @Mapping(target = "birthDate", expression = "java(LocalDate.parse(createRequest.getBirthDate()))")
    Athlete toDomain(AthleteCreateRequest createRequest);

    Athlete toDomain(AthleteUpdateRequest updateRequest);
}

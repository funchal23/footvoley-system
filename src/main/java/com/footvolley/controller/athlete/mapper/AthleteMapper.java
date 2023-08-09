package com.footvolley.controller.athlete.mapper;

import com.footvolley.controller.athlete.dto.AthleteRequest;
import com.footvolley.domain.athlete.Athlete;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AthleteMapper {

    Athlete toDomain(AthleteRequest athleteRequest);
}

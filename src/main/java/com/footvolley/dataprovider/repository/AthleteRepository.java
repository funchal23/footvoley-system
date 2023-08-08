package com.footvolley.dataprovider.repository;

import com.footvolley.domain.athlete.Athlete;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AthleteRepository extends MongoRepository<Athlete, String> {
}
package com.footvolley.dataprovider.repository;

import com.footvolley.domain.athlete.Athlete;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AthleteRepository extends MongoRepository<Athlete, String> {
    Optional<Athlete> findByCpf(String cpf);
}
package com.footvolley.service.athlete;

import com.footvolley.dataprovider.repository.AthleteRepository;
import com.footvolley.domain.athlete.Athlete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public Athlete create(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public List<Athlete> findByIds(Set<String> ids) {
        return athleteRepository.findAllById(ids);
    }

    public void deleteById(String id) {
        athleteRepository.deleteById(id);
    }

    public Athlete update(String id, Athlete athlete) {
        Athlete athleteToUpdate = athleteRepository.findById(id).orElseThrow(() -> new RuntimeException("Athlete not found"));
        athleteToUpdate.setName(athlete.getName());
        athleteToUpdate.setCpf(athlete.getCpf());
        return athleteRepository.save(athleteToUpdate);
    }
}

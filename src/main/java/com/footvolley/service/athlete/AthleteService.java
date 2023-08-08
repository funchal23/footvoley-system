package com.footvolley.service.athlete;

import com.footvolley.dataprovider.repository.AthleteRepository;
import com.footvolley.domain.athlete.Athlete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public Athlete create(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public Athlete findById(String id) throws Exception {
        return athleteRepository.findById(id).orElseThrow(() -> new Exception(id.toString()));
    }

    public List<Athlete> findAll() {
        return athleteRepository.findAll();
    }

    public void deleteById(String id) {
        athleteRepository.deleteById(id);
    }

    public Athlete update(String id, Athlete athlete) throws Exception {
        Athlete athleteToUpdate = findById(id);
        athleteToUpdate.setName(athlete.getName());
        return athleteRepository.save(athleteToUpdate);
    }
}

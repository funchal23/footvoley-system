package com.footvolley.service.athlete;

import com.footvolley.common.exception.AthleteNotFoundException;
import com.footvolley.common.exception.CpfFindingException;
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
        athleteRepository.findByCpf(athlete.getCpf()).ifPresent(athleteFound -> {
            throw new CpfFindingException();
        });
        return athleteRepository.save(athlete);
    }

    public List<Athlete> findByIds(Set<String> ids) {
        return athleteRepository.findAllById(ids);
    }

    public void deleteById(String id) {
        athleteRepository.deleteById(id);
    }

    public Athlete update(String id, Athlete athlete) {
        Athlete athleteToUpdate = athleteRepository.findById(id).orElseThrow(AthleteNotFoundException::new);
        athleteToUpdate.setPhoneNumber(athlete.getPhoneNumber());
        athleteToUpdate.setNickName(athlete.getNickName());
        return athleteRepository.save(athleteToUpdate);
    }
}

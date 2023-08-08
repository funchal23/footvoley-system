package com.footvolley.controller.athlete;

import com.footvolley.domain.athlete.Athlete;
import com.footvolley.service.athlete.AthleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/athletes")
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteService service;
    @GetMapping
    public List<Athlete> listAthletes() {
        return service.findAll();
    }

    @PostMapping
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        return service.create(athlete);
    }

    @GetMapping("/{id}")
    public Athlete getAthleteById(@PathVariable String id) throws Exception {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Athlete updateAthlete(@PathVariable String id, @RequestBody Athlete athlete) throws Exception {
        Athlete existingAthlete = service.findById(id);
        existingAthlete.setName(athlete.getName());
        return service.create(existingAthlete);
    }

    @DeleteMapping("/{id}")
    public void deleteAthlete(@PathVariable String id) {
        service.deleteById(id);
    }
}


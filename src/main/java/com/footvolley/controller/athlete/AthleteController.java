package com.footvolley.controller.athlete;

import com.footvolley.controller.athlete.dto.AthleteCreateRequest;
import com.footvolley.controller.athlete.dto.AthleteUpdateRequest;
import com.footvolley.controller.athlete.mapper.AthleteMapper;
import com.footvolley.domain.athlete.Athlete;
import com.footvolley.service.athlete.AthleteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/athletes")
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteService service;
    private final AthleteMapper mapper;

    @PostMapping
    public ResponseEntity<?> createAthlete(@RequestBody @Valid AthleteCreateRequest athlete, BindingResult bindingResult){
        List<String> errors = validBindingResult(bindingResult);
        if (!errors.isEmpty()) return ResponseEntity.badRequest().body(errors);
        Athlete athleteCreated = service.create(mapper.toDomain(athlete));
        return ResponseEntity.created(URI.create("/athletes/".concat(athleteCreated.getId()))).body(athleteCreated);
    }

    @GetMapping
    public List<Athlete> getAthletes(@RequestParam(value = "ids") final Set<String> ids) {
        return service.findByIds(ids);
    }

    @PutMapping("/{id}")
    public Athlete updateAthlete(@PathVariable String id, @RequestBody @Valid AthleteUpdateRequest athlete) {
        return service.update(id, mapper.toDomain(athlete));
    }

    @DeleteMapping("/{id}")
    public void deleteAthlete(@PathVariable String id) {
        service.deleteById(id);
    }

    private List<String> validBindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());

        }
        return List.of();
    }
}


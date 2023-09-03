package com.footvolley;

import com.footvolley.dataprovider.repository.AthleteRepository;
import com.footvolley.domain.athlete.Athlete;
import com.footvolley.service.athlete.AthleteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@MockitoSettings
class AthleteServiceTest {

	@InjectMocks
	private AthleteService athleteService;

	@Mock
	private AthleteRepository athleteRepository;

	@Test
	void testCreateAthlete() {
		Athlete athlete = new Athlete();
		when(athleteRepository.findByCpf(athlete.getCpf())).thenReturn(Optional.empty());
		when(athleteRepository.save(athlete)).thenReturn(athlete);
		Athlete createdAthlete = athleteService.create(athlete);
		Assertions.assertNotNull(createdAthlete);
	}

	@Test
	void testFindByIds() {
		Set<String> ids = new HashSet<>();
		ids.add("1");
		ids.add("2");
		when(athleteRepository.findAllById(ids)).thenReturn(List.of());
		List<Athlete> foundAthletes = athleteService.findByIds(ids);
		Assertions.assertTrue(foundAthletes.isEmpty());
	}

	@Test
	void testDeleteById() {
		String idToDelete = "1";
		doNothing().when(athleteRepository).deleteById(idToDelete);
		assertDoesNotThrow(() -> athleteService.deleteById(idToDelete));
	}

	@Test
	void testUpdateAthlete() {
		String idToUpdate = "1";
		Athlete athleteToUpdate = new Athlete();
		athleteToUpdate.setPhoneNumber("123-456-7890");
		athleteToUpdate.setNickName("Nickname");
		when(athleteRepository.findById(idToUpdate)).thenReturn(Optional.of(athleteToUpdate));
		when(athleteRepository.save(athleteToUpdate)).thenReturn(athleteToUpdate);
		Athlete updatedAthlete = athleteService.update(idToUpdate, athleteToUpdate);
		Assertions.assertNotNull(updatedAthlete);
		Assertions.assertEquals("123-456-7890", updatedAthlete.getPhoneNumber());
		Assertions.assertEquals("Nickname", updatedAthlete.getNickName());
	}
}

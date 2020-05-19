package diploma.autos.rating;

import diploma.autos.rating.dto.*;
import diploma.autos.rating.repositories.EngineRatingRepository;
import diploma.autos.rating.repositories.GearboxRatingRepository;
import diploma.autos.rating.repositories.GeneralCarRatingRepository;
import diploma.autos.rating.services.RatingService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.AdditionalMatchers.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RatingApplicationTests {

	@MockBean
	EngineRatingRepository engineRatingRepository;
	@MockBean
	GearboxRatingRepository gearboxRatingRepository;
	@MockBean
	GeneralCarRatingRepository generalCarRatingRepository;

	@Autowired
	RatingService ratingService;


	@Test
	public void ratingCalculationTest() throws Exception {

		// create mockito meaningful response
		EngineRatingDTO engineRating = new EngineRatingDTO();
		engineRating.setRating(4);
		Optional<EngineRatingDTO> engineRatingOptional = Optional.of(engineRating);

		// create mockito meaningful argument
		EngineRatingDTOPK engineRatingDTOPK = new EngineRatingDTOPK("bmw", "b58", 3.0);

		// create wrong mockito response
		Optional<EngineRatingDTO> wrongEngineRatingOptional = Optional.of(new EngineRatingDTO());


		// create mockito meaningful argument
		GearboxRatingDTOPK gearboxRatingDTOPK =
				new GearboxRatingDTOPK("bmw", "5DS", "manual");

		// create mockito meaningful response
		GearboxRatingDTO gearboxRatingDTO = new GearboxRatingDTO();
		gearboxRatingDTO.setRating(5);
		Optional<GearboxRatingDTO> gearboxRatingDTOOptional = Optional.of(gearboxRatingDTO);

		// create wrong mockito response
		Optional<GearboxRatingDTO> wrongGearboxRatingOptional = Optional.of(new GearboxRatingDTO());


		// create mockito meaningful argument
		GeneralCarRatingDTOPK generalCarRatingDTOPK =
				new GeneralCarRatingDTOPK("bmw", "328");

		// create mockito meaningful response
		GeneralCarRatingDTO generalCarRatingDTO = new GeneralCarRatingDTO();
		generalCarRatingDTO.setRating(6);
		Optional<GeneralCarRatingDTO> generalCarRatingDTOOptional = Optional.of(generalCarRatingDTO);

		// create wrong mockito response
		Optional<GeneralCarRatingDTO> wrongCarRatingDTOOptional = Optional.of(new GeneralCarRatingDTO());

		// when engineRatingDTOPK passed as an argument, return some meaningful value
		when(engineRatingRepository.findById(eq(engineRatingDTOPK))).thenReturn(engineRatingOptional);
		when(engineRatingRepository.findById(not(eq(engineRatingDTOPK)))).thenReturn(wrongEngineRatingOptional);

		when(gearboxRatingRepository.findById(eq(gearboxRatingDTOPK))).thenReturn(gearboxRatingDTOOptional);
		when(gearboxRatingRepository.findById(not(eq(gearboxRatingDTOPK)))).thenReturn(wrongGearboxRatingOptional);

		when(generalCarRatingRepository.findById(eq(generalCarRatingDTOPK))).thenReturn(generalCarRatingDTOOptional);
		when(generalCarRatingRepository.findById(not(eq(generalCarRatingDTOPK)))).thenReturn(wrongCarRatingDTOOptional);

		Double rating = ratingService.countCarRating(
				"bmw",
				"328",
				"bmw",
				"b58",
				3.0,
				"bmw",
				"5DS",
				"manual"
		);

		assertEquals((4+5+6)/3.0, rating);
	}


}

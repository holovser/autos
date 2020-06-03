package diploma.autos.similarity.services;

import diploma.autos.similarity.entities.Advertisement;
import diploma.autos.similarity.entities.Car;
import diploma.autos.similarity.repositories.AdvertisementRepository;
import diploma.autos.similarity.repositories.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class SimilarityApplicationTests {

	@Autowired
	SimilarityService similarityService;

	@MockBean
	CarRepository carRepository;

	@MockBean
	AdvertisementRepository advertisementRepository;

	@Test
	public void findCarByIdTest() throws Exception {

		Car foundCar = new Car();
		foundCar.setCarId(1);

		Car wrongCar = new Car();
		wrongCar.setCarId(0);

		when(carRepository.findByCarId(eq(1))).thenReturn(Optional.of(foundCar));
		when(carRepository.findByCarId(not(eq(1)))).thenReturn(Optional.of(wrongCar));

		assertEquals(foundCar, similarityService.findCarById(1));
	}

	@Test
	@Deprecated
	public void findSimilarMileageCarsTest() {

		int pivotPrice = 10000;
		int lowerPivotPrice = 8000;
		int upperPivotPrice = 12000;

		Car firstCar = new Car();
		firstCar.setCarId(1);

		Car secondCar = new Car();
		secondCar.setCarId(2);

		List<Car> foundExpectedCars = Arrays.asList(firstCar, secondCar);

		when(carRepository
				.findByMileageGreaterThanEqualAndMileageLessThanEqual(lowerPivotPrice, upperPivotPrice))
				.thenReturn(foundExpectedCars);

		when(carRepository
				.findByMileageGreaterThanEqualAndMileageLessThanEqual(not(eq(lowerPivotPrice)), not(eq(upperPivotPrice))))
				.thenReturn(Arrays.asList());

		assertEquals(foundExpectedCars, similarityService.findSimilarMileageCars(pivotPrice));
	}

	@Test
	public void findSimilarRatingCarsTest() {
		double pivotRating = 5.0;
		double lowPivotRating = pivotRating * 0.6;
		double highPivotRating = pivotRating * 1.4;

		Advertisement adv1 = new Advertisement();
		adv1.setAdvertisementId(1);

		Advertisement adv2 = new Advertisement();
		adv2.setAdvertisementId(2);


		when(advertisementRepository
				.findByRatingGreaterThanEqualAndRatingLessThanEqual(eq(lowPivotRating), eq(highPivotRating)))
				.thenReturn(Arrays.asList(adv1, adv2));

		when(advertisementRepository
				.findByRatingGreaterThanEqualAndRatingLessThanEqual(not(eq(lowPivotRating)), not(eq(highPivotRating))))
				.thenReturn(Arrays.asList());

		assertEquals(Arrays.asList(adv1, adv2), similarityService.findSimilarRatingAdvs(pivotRating));
	}

	@Test
	public void findSimilarPriceCarsTest() {
		int pivotPrice = 3000;
		int lowPivotPrice = (int)(pivotPrice*0.8);
		int highPivotPrice = (int)(pivotPrice*1.2);
		System.out.println(lowPivotPrice);

		Advertisement adv1 = new Advertisement();
		adv1.setAdvertisementId(1);

		Advertisement adv2 = new Advertisement();
		adv2.setAdvertisementId(2);


		when(advertisementRepository
				.findByPriceGreaterThanEqualAndPriceLessThanEqual(eq(lowPivotPrice), eq(highPivotPrice)))
				.thenReturn(Arrays.asList(adv1, adv2));

		when(advertisementRepository
				.findByPriceGreaterThanEqualAndPriceLessThanEqual(not(eq(lowPivotPrice)), not(eq(lowPivotPrice))))
				.thenReturn(Arrays.asList());

		assertEquals(Arrays.asList(adv1, adv2), similarityService.findSimilarPriceAdvs(pivotPrice));
	}


}




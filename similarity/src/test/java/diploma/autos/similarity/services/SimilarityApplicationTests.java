package diploma.autos.similarity.services;

import diploma.autos.similarity.entities.Car;
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
}

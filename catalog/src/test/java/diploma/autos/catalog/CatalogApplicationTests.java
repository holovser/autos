package diploma.autos.catalog;

import diploma.autos.catalog.entities.Car;
import diploma.autos.catalog.repositories.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CatalogApplicationTests {

	@Autowired
	private CarRepository carRepository;

	@Before
	public void init() {

	}

	@Transactional
	@Test
	public void test1() {

		Car tmpCar = new Car();
        tmpCar.setCarId(7);
        tmpCar.setBrand("1234");
        tmpCar.setModel("1234");

        carRepository.save(tmpCar);

		System.out.println(carRepository.findAll());
	}


//	@Test
//	void test2() {
//
//		Car tmpCar = new Car();
//		tmpCar.setCarId(6);
//		tmpCar.setBrand("2");
//		tmpCar.setModel("2");
//
//		carRepository.save(tmpCar);
//
//		System.out.println(carRepository.findAll());
//	}

}

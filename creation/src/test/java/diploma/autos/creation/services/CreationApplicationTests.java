package diploma.autos.creation.services;

import diploma.autos.creation.entities.*;
import diploma.autos.creation.repositories.AdvertisementRepository;
import diploma.autos.creation.services.CreateAdvertisementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;

import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@SpringBootTest
class CreationApplicationTests {

    @Autowired
    private AdvertisementRepository advRepository;

    @Autowired
    private CreateAdvertisementService createAdvertisementService;

    @Autowired
    RestTemplate restTemplate;

    @BeforeEach
    public void init() {

    }

    @Test
//	@Rollback
	@Transactional
    public void createAdvertisementTest() {
        Advertisement adv = new Advertisement();
//        advRepository.save(adv);
//		System.out.println("test");
        assertThrows(DataIntegrityViolationException.class, () -> advRepository.save(adv));
//		System.out.println(advRepository.findAll());
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    @Test
	public void createURITest() {

    	Advertisement adv = new Advertisement();
		adv.setPrice(500);

		Car car = new Car();
		car.setBrand("bmw");
		car.setModel("328");
		car.setMileage(200000);

		Engine engine = new Engine();

		EngineId engineId = new EngineId();
		engineId.setEngineBrand("bmw");
		engineId.setEngineModel("b58");
		engineId.setEngineVolume(3);

		engine.setEngineId(engineId);

		car.setEngine(engine);

		Gearbox gearbox = new Gearbox();

		GearboxId gearboxId = new GearboxId();
		gearboxId.setGearboxBrand("bmw");
		gearboxId.setGearboxModel("5DS");
		gearboxId.setGearboxType("manual");

		gearbox.setGearboxId(gearboxId);

		car.setGearbox(gearbox);

		adv.setCar(car);

		URI targetURIActual = createAdvertisementService.createRatingURI(adv);
		String queryActual = targetURIActual.getQuery();

		assertEquals("/rating", targetURIActual.getPath());

		assertAll(
				() -> assertTrue( targetURIActual.getQuery().contains("car_brand=bmw")),
				() -> assertTrue( targetURIActual.getQuery().contains("car_model=328")),
				() -> assertTrue( targetURIActual.getQuery().contains("engine_brand=bmw")),
				() -> assertTrue( targetURIActual.getQuery().contains("engine_model=b58")),
				() -> assertTrue( targetURIActual.getQuery().contains("engine_volume=3.0")),
				() -> assertTrue( targetURIActual.getQuery().contains("gearbox_brand=bmw")),
				() -> assertTrue( targetURIActual.getQuery().contains("gearbox_model=5DS")),
				() -> assertTrue( targetURIActual.getQuery().contains("gearbox_type=manual"))
				);
	}
}

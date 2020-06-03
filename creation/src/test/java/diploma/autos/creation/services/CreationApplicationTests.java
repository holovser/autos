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


    @Test
    public void createAdvertisementTest() {
        Advertisement adv = new Advertisement();
        assertThrows(DataIntegrityViolationException.class, () -> advRepository.save(adv));
    }

    @Test
	public void createURITest() {

		URI targetURIActual = createAdvertisementService.createRatingURI();

		assertEquals("/rating", targetURIActual.getPath());
	}
}

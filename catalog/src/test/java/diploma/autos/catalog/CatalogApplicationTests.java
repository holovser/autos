package diploma.autos.catalog;

import diploma.autos.catalog.dto.AdvertisementDTO;
import diploma.autos.catalog.entities.Advertisement;
import diploma.autos.catalog.entities.Author;
import diploma.autos.catalog.repositories.AdvertisementDTORepository;
import diploma.autos.catalog.repositories.AdvertisementRepository;
import diploma.autos.catalog.repositories.CarRepository;
import diploma.autos.catalog.services.RetrievingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CatalogApplicationTests {

	@MockBean
	private CarRepository carRepository;

	@MockBean
	private AdvertisementDTORepository advertisementDTORepository;

	@MockBean
	private AdvertisementRepository advertisementRepository;

	@Autowired
	private RetrievingService retrievingService;



	@Test
	public void findAllAdvertisementsTest() {

		AdvertisementDTO adv1 = new AdvertisementDTO();
		adv1.setAdvertisementId(1);

		AdvertisementDTO adv2 = new AdvertisementDTO();
		adv2.setAdvertisementId(2);

		when(advertisementDTORepository.findAll()).thenReturn(Arrays.asList(adv1, adv2));

		assertEquals(Arrays.asList(adv1, adv2), retrievingService.getAdvsDTO());
	}

	@Test
	public void findAdvertisementByIdTest() throws Exception {
		Integer id = 1;

		Advertisement adv = new Advertisement();
		adv.setAdvertisementId(id);

		when(advertisementRepository.findAdvertisementByAdvertisementId(eq(id))).thenReturn(Optional.of(adv));

		assertEquals(adv, retrievingService.getAdvByAdvId(id));
	}


	@Test
	public void findAuthorByAdvTest() throws Exception {
		Integer id = 1;

		Advertisement adv = new Advertisement();
		adv.setAdvertisementId(id);

		Author author = new Author();
		author.setAuthorId(1);

		adv.setAuthor(author);

		when(advertisementRepository.findAdvertisementByAdvertisementId(eq(id))).thenReturn(Optional.of(adv));

		assertEquals(author, retrievingService.getAdvAuthor(id));
	}



}

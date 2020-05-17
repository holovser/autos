package diploma.autos.creation.services;

import diploma.autos.creation.dto.AdvertisementDTO;
import diploma.autos.creation.dto.AuthorDTO;
import diploma.autos.creation.dto.CarDTO;
import diploma.autos.creation.entities.Advertisement;
import diploma.autos.creation.exceptions.CreateAdvertisementException;
import diploma.autos.creation.repositories.AdvertisementDTORepository;
import diploma.autos.creation.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CreateAdvertisementService {

    public CreateAdvertisementService() {
    }

    @Autowired
    private AdvertisementRepository advRepository;

    @Autowired
    private RestTemplate restTemplate;

    protected URI createRatingURI(Advertisement adv) {
        URI targetUrl = UriComponentsBuilder.fromUriString("http://cars-rating-service")  // Build the base link
                .path("/rating")                            // Add path
                .queryParam("car_brand", adv.getCar().getBrand())                                // Add one or more query params
                .queryParam("car_model", adv.getCar().getModel())
                .queryParam("engine_brand", adv.getCar().getEngine().getEngineId().getEngineBrand())
                .queryParam("engine_model", adv.getCar().getEngine().getEngineId().getEngineModel())
                .queryParam("engine_volume", adv.getCar().getEngine().getEngineId().getEngineVolume())
                .queryParam("gearbox_brand", adv.getCar().getGearbox().getGearboxId().getGearboxBrand())
                .queryParam("gearbox_model", adv.getCar().getGearbox().getGearboxId().getGearboxModel())
                .queryParam("gearbox_type", adv.getCar().getGearbox().getGearboxId().getGearboxType())
                .build()                                                 // Build the URL
                .encode()                                                // Encode any URI items that need to be encoded
                .toUri();
        return targetUrl;
    }

    public void createAdvertisement(Advertisement adv) throws CreateAdvertisementException {
//        if ( advRepository.findAdvertisementByAdvertisementId(adv.getAdvertisementId()).isPresent() ) {
//            System.out.println("Save advertisement");
//            advRepository.save(adv);
//        } else {
//            throw new CreateAdvertisementException("Advertisement already exists");
//        }

        System.out.println("Test");
        URI targetRatingUrl = createRatingURI(adv);
        System.out.println("Test");
        Double ratingValue = 0.0;
        try {
            ratingValue = restTemplate.getForObject(targetRatingUrl, Double.class);
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Rating: " + ratingValue);

        adv.setRating(ratingValue);
        advRepository.save(adv);
    }

}

package diploma.autos.creation.services;

import diploma.autos.creation.dto.AdvertisementDTO;
import diploma.autos.creation.dto.AuthorDTO;
import diploma.autos.creation.dto.CarDTO;
import diploma.autos.creation.entities.Advertisement;
import diploma.autos.creation.exceptions.CreateAdvertisementException;
import diploma.autos.creation.model.Request;
import diploma.autos.creation.repositories.AdvertisementDTORepository;
import diploma.autos.creation.repositories.AdvertisementRepository;
import diploma.autos.creation.repositories.GearboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
//
//    @Autowired
//    private EngineRepository engineRepository;
//
//    @Autowired
//    private GearboxRepository gearboxRepository;

    @Autowired
    private RestTemplate restTemplate;

    protected URI createRatingURI() {
        URI targetUrl = UriComponentsBuilder.fromUriString("http://cars-rating-service")  // Build the base link
                .path("/rating")                            // Add path
                .build()                                                 // Build the URL
                .encode()                                                // Encode any URI items that need to be encoded
                .toUri();
        return targetUrl;
    }

    protected Request createRequest(Advertisement adv) {
        Request request = new Request(adv.getCar().getBrand(),
                adv.getCar().getModel(),
                adv.getCar().getEngine().getEngineId().getEngineBrand(),
                adv.getCar().getEngine().getEngineId().getEngineModel(),
                adv.getCar().getEngine().getEngineId().getEngineVolume(),
                adv.getCar().getGearbox().getGearboxId().getGearboxBrand(),
                adv.getCar().getGearbox().getGearboxId().getGearboxModel(),
                adv.getCar().getGearbox().getGearboxId().getGearboxType()
        );
        return request;
    }

    public void createAdvertisement(Advertisement adv) throws CreateAdvertisementException {
        URI targetRatingUrl = createRatingURI();
        ResponseEntity<Double> ratingEntity;
        Double ratingValue = 0.0;
        try {
            Request request = createRequest(adv);
            ratingEntity = restTemplate.postForEntity( targetRatingUrl, request, Double.class);
            ratingValue = ratingEntity.getBody();
//            ratingValue = restTemplate.getForObject(targetRatingUrl, Double.class);
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Rating: " + ratingValue);

        adv.setRating(ratingValue);
        advRepository.save(adv);
    }

}

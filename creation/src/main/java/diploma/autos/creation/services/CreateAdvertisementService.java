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


/**
 * Service which holds the main logic for inserting a new advertisement
 */
@Service
public class CreateAdvertisementService {

    public CreateAdvertisementService() {
    }

    /**
     * Repository for retrieving an persisting advertisements
     */
    @Autowired
    private AdvertisementRepository advRepository;

    /**
     * Object which makes possible sending http requests to concrete microservices retrieving their address from db
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @return URI which target the rating microservice which is passed to the Eureka server and the real URI received
     */
    protected URI createRatingURI() {
        URI targetUrl = UriComponentsBuilder.fromUriString("http://cars-rating-service")  // Build the base link
                .path("/rating")                            // Add path
                .build()                                                 // Build the URL
                .encode()                                                // Encode any URI items that need to be encoded
                .toUri();
        return targetUrl;
    }


    /**
     *
     * @param adv Advertisement from which the request object is created
     * @return Request object which is passed in the request body when calling the rating microservice
     */
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


    /**
     *
     * @param adv Advertisement to be inserted
     */
    public void createAdvertisement(Advertisement adv) {
        URI targetRatingUrl = createRatingURI();
        ResponseEntity<Double> ratingEntity;
        Double ratingValue = 0.0;
        try {
            Request request = createRequest(adv);
            ratingEntity = restTemplate.postForEntity( targetRatingUrl, request, Double.class);
            ratingValue = ratingEntity.getBody();
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Rating: " + ratingValue);

        adv.setRating(ratingValue);
        advRepository.save(adv);
    }

}

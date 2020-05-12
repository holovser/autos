package diploma.autos.creation.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.creation.dto.AdvertisementDTO;
import diploma.autos.creation.dto.AuthorDTO;
import diploma.autos.creation.dto.CarDTO;
import diploma.autos.creation.entities.Advertisement;
import diploma.autos.creation.requests.CreateRequest;
import diploma.autos.creation.services.CreateAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RestController
public class CreateAdvertisementController {

    @Autowired
    private RestTemplate restTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    public CreateAdvertisementController() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm.sss.S");
        mapper.setDateFormat(df);
    }

    @Autowired
    private CreateAdvertisementService createAdvertisementService;

//    @PostMapping("/adv/create")
//    public ResponseEntity<String> createAdvertising(
//            @RequestBody CreateRequest createRequest
//            ) throws JsonProcessingException {
//        String responseJSON = "";
//        URI targetUrl = UriComponentsBuilder.fromUriString("http://cars-rating-service")  // Build the base link
//                .path("/rating")                            // Add path
//                .queryParam("car_brand", createRequest.getCar().getBrand())                                // Add one or more query params
//                .queryParam("car_model", createRequest.getCar().getModel())
//                .queryParam("engine_brand", createRequest.getEngine().getEngineBrand())
//                .queryParam("engine_model", createRequest.getEngine().getEngineModel())
//                .queryParam("engine_volume", createRequest.getEngine().getEngineVolume())
//                .queryParam("gearbox_brand", createRequest.getGearbox().getGearboxBrand())
//                .queryParam("gearbox_model", createRequest.getGearbox().getGearboxModel())
//                .queryParam("gearbox_type", createRequest.getGearbox().getGearboxType())
//                .build()                                                 // Build the URL
//                .encode()                                                // Encode any URI items that need to be encoded
//                .toUri();
//        Double ratingValue = restTemplate.getForObject(targetUrl, Double.class);
//        System.out.println("Rating: " + ratingValue);
//
//        AdvertisementDTO adv = createRequest.getAdv();
//        adv.setRating(ratingValue);
//        AuthorDTO author = createRequest.getAuthor();
//        CarDTO car = createRequest.getCar();
//        try {
//            createAdvertisementService.createAdvertisement(adv, car, author);
//            responseJSON = mapper.writeValueAsString(adv);
//            System.out.println(responseJSON);
//        } catch (Exception e) {
//            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.NOT_ACCEPTABLE);
//        }
//
//        return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
//    }

    @PostMapping("/adv")
    public ResponseEntity<String> createAdvertising(
            @RequestBody Advertisement adv
            ) throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(adv));
        String responseJSON = "";

        try {
            createAdvertisementService.createAdvertisement(adv);
            responseJSON = mapper.writeValueAsString(adv);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String testResponse() {
        return "TEST RESPONSE";
    }
}

package diploma.autos.creation.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.creation.dto.AdvertisementDTO;
import diploma.autos.creation.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import diploma.autos.creation.services.CreateAdvertisementService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
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

    @PostMapping("/adv/create")
    public ResponseEntity<String> createAdvertising(@RequestBody AdvertisementDTO adv, @RequestBody CarDTO car) throws JsonProcessingException {
        String responseJSON = "";
        URI targetUrl= UriComponentsBuilder.fromUriString("http://cars-rating-service")  // Build the base link
                .path("/rating")                            // Add path
                .queryParam("name", "sergej")                                // Add one or more query params
                .build()                                                 // Build the URL
                .encode()                                                // Encode any URI items that need to be encoded
                .toUri();
        String ratingResponse = restTemplate.getForObject(targetUrl, String.class);
        System.out.println(ratingResponse);
        try {
            createAdvertisementService.createAdvertisement(adv);
            responseJSON = mapper.writeValueAsString(adv);
        } catch (Exception e) {
            responseJSON = mapper.writeValueAsString(adv);
//            System.out.println(responseJSON);
            return new ResponseEntity<String>(e.getMessage(), null , HttpStatus.NOT_ACCEPTABLE);

        }

        return new ResponseEntity<String>(responseJSON, null , HttpStatus.OK);
    }
}

package diploma.autos.creation.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.creation.entities.Advertisement;
import diploma.autos.creation.services.CreateAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Controller responsible for inserting bew advertisement to the db
 */
@RestController
public class CreateAdvertisementController {

    /**
     * Service which holds the main logic for inserting new advertisement
     */
    @Autowired
    private CreateAdvertisementService createAdvertisementService;

    /**
     * Object which serialize Java objects
     */
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Controller in which the date format of the mapper is set
     */
    public CreateAdvertisementController() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm.sss.S");
        mapper.setDateFormat(df);
    }


    /**
     *
     * @param adv Complete advertisement object
     * @return ResponseEntity object
     * @throws JsonProcessingException Exception is thrown when problems in serialization occur
     */
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
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
    }
}

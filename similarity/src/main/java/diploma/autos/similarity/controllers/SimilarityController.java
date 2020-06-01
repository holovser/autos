package diploma.autos.similarity.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.similarity.entities.Car;
import diploma.autos.similarity.exceptions.NotFoundException;
import diploma.autos.similarity.repositories.AdvertisementRepository;
import diploma.autos.similarity.services.SimilarityService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

/**
 * Controller responsible for returning similar advertisements to particular car
 */
@RestController
public class SimilarityController {

    private ObjectMapper mapper = new ObjectMapper();

    public SimilarityController() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm.sss.S");
        mapper.setDateFormat(df);
    }

    /**
     * Service which holds the main similarity logic
     */
    @Autowired
    private SimilarityService similarityService;

    /**
     *
     * @param car
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping("/similar")
    ResponseEntity<String> findSimilarCars(Car car) throws JsonProcessingException {
        String responseJSON = "";
        System.out.println(car);
        try {
            Set similarAdvs = similarityService.findSimilarAdvs(car.getCarId());
            responseJSON = mapper.writeValueAsString(similarAdvs);
            return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
        } catch( NotFoundException e ) {
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

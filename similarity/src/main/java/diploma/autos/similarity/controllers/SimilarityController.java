package diploma.autos.similarity.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.similarity.entities.Car;
import diploma.autos.similarity.repositories.AdvertisementRepository;
import diploma.autos.similarity.services.SimilarityService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimilarityController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private SimilarityService similarityService;

    @PostMapping("/similar")
    ResponseEntity<String> findSimilarCars(@RequestBody Car car) throws JsonProcessingException {
        String responseJSON = "";
        JSONArray jsonArray;
        try {
            List similarCars = similarityService.findSimilarCars(car.getCarId());
            responseJSON = mapper.writeValueAsString(similarCars);
//            System.out.println("Response json: " + responseJSON);
//            jsonArray = new JSONArray(responseString);
        } catch (Exception e ) {
            System.out.println("Exception: " + e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
    }


}

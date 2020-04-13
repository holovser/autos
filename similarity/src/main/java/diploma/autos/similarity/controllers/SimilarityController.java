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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class SimilarityController {

    private ObjectMapper mapper;

    public SimilarityController() {
        mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm.sss.S");
        mapper.setDateFormat(df);
    }

    @Autowired
    private SimilarityService similarityService;

    @PostMapping("/similar")
    ResponseEntity<String> findSimilarCars(@RequestBody Car car) throws JsonProcessingException {
        String responseJSON = "";
        JSONArray jsonArray;
        try {
            List similarAdvs = similarityService.findSimilarAdvs(car.getCarId());
            System.out.println("Test");
            responseJSON = mapper.writeValueAsString(similarAdvs);
            return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.NOT_ACCEPTABLE);
        }
    }


}

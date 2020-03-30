package diploma.autos.similarity.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.similarity.entities.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimilarityController {

    private ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/similar")
    List<Car> findSimilarCars(@RequestBody Car car) throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(car));
        return null;
    }


}

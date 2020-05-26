package diploma.autos.rating.controllers;

import diploma.autos.rating.model.Request;
import diploma.autos.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingsController {


    @Autowired
    RatingService ratingService;

    @PostMapping("/rating")
    @ResponseBody
    Double getCarRating(
            @RequestBody Request requestData
            ) {
        try {
            System.out.println(requestData);
            double carRating = ratingService.countCarRating(
                    requestData.getCarBrand(),
                    requestData.getCarModel(),
                    requestData.getEngineBrand(),
                    requestData.getEngineModel(),
                    requestData.getEngineVolume(),
                    requestData.getGearboxBrand(),
                    requestData.getGearboxModel(),
                    requestData.getGearboxType()
            );
            System.out.println(carRating);
            return carRating;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}

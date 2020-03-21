package diploma.autos.rating.controllers;

import diploma.autos.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingsController {


    @Autowired
    RatingService ratingService;

    @GetMapping("/rating")
    Integer getCarRating(
            @RequestParam(name = "car_brand") String carBrand,
            @RequestParam(name = "car_model") String carModel,
            @RequestParam(name = "engine_brand") String engineBrand,
            @RequestParam(name = "engine_model") String engineModel,
            @RequestParam(name = "engine_volume") Double engineVolume,
            @RequestParam(name = "gearbox_brand") String gearboxBrand,
            @RequestParam(name = "gearbox_model") String gearboxModel,
            @RequestParam(name = "gearbox_type") String gearboxType

    ) {
        try {
            int carRating = ratingService.countCarRating(
                    carBrand,
                    carModel,
                    engineBrand,
                    engineModel,
                    engineVolume,
                    gearboxBrand,
                    gearboxModel,
                    gearboxType
            );
//            System.out.println(carRating);
            return carRating;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}

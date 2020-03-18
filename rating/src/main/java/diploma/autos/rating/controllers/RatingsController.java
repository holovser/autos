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
            @RequestParam(name = "engine_brand") String engineBrand,
            @RequestParam(name = "engine_model") String engineModel,
            @RequestParam(name = "volume") Double volume,
            @RequestParam(name = "gearbox_brand") String gearboxBrand,
            @RequestParam(name = "gearbox_type") String gearboxType
    ) {
        int carRating = 0;
        try {
            carRating = ratingService.countCarRating(
                    engineBrand,
                    engineModel,
                    volume,
                    gearboxBrand,
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

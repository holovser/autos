package diploma.autos.rating.controllers;

import diploma.autos.rating.model.Request;
import diploma.autos.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller which is responsible for returning a rating value
 */
@RestController
public class RatingsController {

    /**
     * Service which holds the main logic for assigning a rating value
     */
    @Autowired
    RatingService ratingService;


    /**
     * controller method which returns a rating value
     *
     * @param requestData
     * @return
     */
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
            return 0.0;
        }
    }

}

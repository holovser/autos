package diploma.autos.similarity.services;

import diploma.autos.similarity.entities.Advertisement;
import diploma.autos.similarity.entities.Car;
import diploma.autos.similarity.exceptions.NotFoundException;
import diploma.autos.similarity.repositories.AdvertisementRepository;
import diploma.autos.similarity.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service which holds the main similarity logic
 */
@Service
public class SimilarityService {

    /**
     * Repository which is responsible for manipulation and persisting cars
     */
    @Autowired
    private CarRepository carRepository;

    /**
     * Repository which is responsible for manipulation and persisting advertisements
     */
    @Autowired
    private AdvertisementRepository advRepository;

    /**
     *
     * Method retrieves the car by id
     * @param carId
     * @return The car by id
     * @throws Exception
     */
    protected Car findCarById(int carId) throws Exception {
        Optional<Car> pivotCarOptional = carRepository.findByCarId(carId);
        if ( pivotCarOptional.isEmpty() ) {
            System.out.println("Not found pivot car");
            throw new NotFoundException();
        }
        return pivotCarOptional.get();
    }

    /**
     *
     * @param mileage
     * @return Cars which have similar mileage
     */
    protected List<Car> findSimilarMileageCars(int mileage) {
        List<Car> similarMileageCars = carRepository.findByMileageGreaterThanEqualAndMileageLessThanEqual(
                (int)(mileage*0.8), (int)(mileage*1.2)
        );
        return similarMileageCars;
    }

    /**
     *
     * @param pivotPrice
     * @return Advertisements with similar price
     */
    protected List<Advertisement> findSimilarPriceAdvs(int pivotPrice) {
        List<Advertisement> similarPriceAdvs = advRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(
                (int)(pivotPrice*0.8),
                (int)(pivotPrice*1.2));

        return similarPriceAdvs;
    }

    /**
     *
     * @param pivotRating
     * @return Advertisements with similar rating
     */
    protected List<Advertisement> findSimilarRatingAdvs(double pivotRating) {
        List<Advertisement> similarRatingAdvs = advRepository.findByRatingGreaterThanEqualAndRatingLessThanEqual(
                pivotRating*0.6,
                pivotRating*1.4
        );

        return similarRatingAdvs;
    }


    /**
     *
     * @param carId
     * @return Similar advertisements to the concrete car
     * @throws Exception
     */
    public Set<Advertisement> findSimilarAdvs(int carId ) throws Exception {
        Car pivotCar = findCarById(carId);
        Advertisement pivotAdv = pivotCar.getAdv();
        Integer pivotPrice = pivotAdv.getPrice();

        System.out.println("Pivot Price: " +  pivotPrice);
        List<Advertisement> similarPriceAdvs = findSimilarPriceAdvs(pivotCar.getMileage());

        //similar mileage cars retrieving was deprecated because of the absence of sense (cars with similar mileage are not similar)
//        List<Car> similarMileageCars = findSimilarMileageCars(pivotCar.getMileage());

        List<Advertisement> similarRatingAdvs = new ArrayList<Advertisement>();
        if (pivotAdv != null) {
            similarRatingAdvs = findSimilarRatingAdvs(pivotAdv.getRating());
        }

        Set<Advertisement> resultAdvs = new HashSet<Advertisement>();

        resultAdvs.addAll(similarPriceAdvs);
        resultAdvs.addAll(similarRatingAdvs);

        resultAdvs.remove(pivotAdv);

        System.out.println(resultAdvs);

        return resultAdvs;
    }
}

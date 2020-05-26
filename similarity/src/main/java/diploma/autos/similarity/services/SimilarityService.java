package diploma.autos.similarity.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.similarity.entities.Advertisement;
import diploma.autos.similarity.entities.Car;
import diploma.autos.similarity.repositories.AdvertisementRepository;
import diploma.autos.similarity.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SimilarityService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private AdvertisementRepository advRepository;

    private ObjectMapper mapper = new ObjectMapper();

    protected Car findCarById(int carId) throws Exception {
        Optional<Car> pivotCarOptional = carRepository.findByCarId(carId);
        if ( pivotCarOptional.isEmpty() ) {
            System.out.println("Not found pivot car");
            throw new Exception("Not found pivot car");
        }
        return pivotCarOptional.get();
    }

    protected List<Car> findSimilarMileageCars(int mileage) {
        List<Car> similarMileageCars = carRepository.findByMileageGreaterThanEqualAndMileageLessThanEqual(
                (int)(mileage*0.8), (int)(mileage*1.2)
        );
        return similarMileageCars;
    }

    protected List<Advertisement> findSimilarPriceAdvs(int pivotPrice) {
        List<Advertisement> similarPriceAdvs = advRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(
                (int)(pivotPrice*0.8),
                (int)(pivotPrice*1.2));

        return similarPriceAdvs;
    }

    protected List<Advertisement> findSimilarRatingAdvs(double pivotRating) {
        List<Advertisement> similarRatingAdvs = advRepository.findByRatingGreaterThanEqualAndRatingLessThanEqual(
                pivotRating*0.6,
                pivotRating*1.4
        );

        return similarRatingAdvs;
    }


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

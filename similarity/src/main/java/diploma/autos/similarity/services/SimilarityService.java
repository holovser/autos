package diploma.autos.similarity.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.similarity.entities.Advertisement;
import diploma.autos.similarity.entities.Car;
import diploma.autos.similarity.repositories.AdvertisementRepository;
import diploma.autos.similarity.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimilarityService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private AdvertisementRepository advRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private Car findCarById(int carId) throws Exception {
        Optional<Car> pivotCarOptional = carRepository.findByCarId(carId);
        if ( pivotCarOptional.isEmpty() ) {
            System.out.println("Not found pivot car");
            throw new Exception("Not found pivot car");
        }
        return pivotCarOptional.get();
    }

    public List<Car> findSimilarCars(int carId ) throws Exception {
        Car pivotCar = findCarById(carId);
        Advertisement pivotAdv = pivotCar.getAdv();
        Integer pivotPrice = pivotAdv.getPrice();

        System.out.println("Pivot Price: " +  pivotPrice);
        List<Advertisement> similarPriceAdvs =
                advRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(
                        (int)((double)pivotPrice*0.8),
                        (int)((double)pivotPrice*1.2));


//        System.out.println("Pivot Car: " + mapper.writeValueAsString(pivotCar));
//        System.out.println("Pivot Advertisement: " + mapper.writeValueAsString(pivotAdv));
//        System.out.println("Pivot Advertisement: " + pivotAdv.toString());

        System.out.println(similarPriceAdvs);
        return null;
    }

}

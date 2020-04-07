package diploma.autos.similarity.repositories;

import diploma.autos.similarity.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Integer> {
    Optional<Car> findByCarId(int carId);
    List<Car> findByMileageGreaterThanEqualAndAdvLessThanEqual(int lowerMileage, int highMileage);
}

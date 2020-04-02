package diploma.autos.similarity.repositories;

import diploma.autos.similarity.entities.Advertisement;
import diploma.autos.similarity.entities.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    Advertisement findAdvertisementByAdvertisementId(int id);
    List<Advertisement> findByPriceGreaterThan(int lowPrice);
}

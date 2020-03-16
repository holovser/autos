package diploma.autos.catalog.repositories;

import diploma.autos.catalog.entities.Advertisement;
import diploma.autos.catalog.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    Advertisement findAdvertisementByAdvertisementId(int id);
}

package diploma.autos.catalog.repositories;

import diploma.autos.catalog.entities.Advertisement;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    Optional<Advertisement> findAdvertisementByAdvertisementId(int id);
}

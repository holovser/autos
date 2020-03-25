package diploma.autos.creation.repositories;

import diploma.autos.creation.dto.AdvertisementDTO;
import diploma.autos.creation.entities.Advertisement;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {
    Optional<Advertisement> findAdvertisementByAdvertisementId(int id);
}

package diploma.autos.creation.repositories;

import diploma.autos.creation.dto.AdvertisementDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdvertisementDTORepository extends CrudRepository<AdvertisementDTO, Integer> {
    Optional<AdvertisementDTO> findAdvertisementByAdvertisementId(int id);
}

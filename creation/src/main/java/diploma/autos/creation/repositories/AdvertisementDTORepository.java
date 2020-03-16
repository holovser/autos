package diploma.autos.creation.repositories;

import diploma.autos.creation.dto.AdvertisementDTO;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisementDTORepository extends CrudRepository<AdvertisementDTO, Integer> {
    AdvertisementDTO findAdvertisementByAdvertisementId(int id);
}

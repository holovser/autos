package diploma.autos.catalog.repositories;

import diploma.autos.catalog.dto.AdvertisementDTO;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisementDTORepository extends CrudRepository<AdvertisementDTO, Integer> {
    AdvertisementDTO findAdvertisementByAdvertisementId(int id);
}

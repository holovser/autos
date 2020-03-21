package diploma.autos.rating.repositories;

import diploma.autos.rating.dto.GearboxRatingDTO;
import diploma.autos.rating.dto.GearboxRatingDTOPK;
import org.springframework.data.repository.CrudRepository;

public interface GearboxRepository extends CrudRepository<GearboxRatingDTO, GearboxRatingDTOPK> {
    GearboxRatingDTO findByBrandAndType(String brand, String type);
}

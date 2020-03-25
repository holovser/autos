package diploma.autos.rating.repositories;

import diploma.autos.rating.dto.GearboxRatingDTO;
import diploma.autos.rating.dto.GearboxRatingDTOPK;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GearboxRatingRepository extends CrudRepository<GearboxRatingDTO, GearboxRatingDTOPK> {
    @Override
    Optional<GearboxRatingDTO> findById(GearboxRatingDTOPK gearboxRatingDTOPK);
}

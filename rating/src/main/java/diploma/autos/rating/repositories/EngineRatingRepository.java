package diploma.autos.rating.repositories;


import diploma.autos.rating.dto.EngineRatingDTO;
import diploma.autos.rating.dto.EngineRatingDTOPK;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface EngineRatingRepository extends CrudRepository<EngineRatingDTO, EngineRatingDTOPK> {
    @Override
    Optional<EngineRatingDTO> findById(EngineRatingDTOPK engineRatingDTOPK);
}

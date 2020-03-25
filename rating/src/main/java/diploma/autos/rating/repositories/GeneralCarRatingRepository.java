package diploma.autos.rating.repositories;

import diploma.autos.rating.dto.GeneralCarRatingDTO;
import diploma.autos.rating.dto.GeneralCarRatingDTOPK;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GeneralCarRatingRepository extends CrudRepository<GeneralCarRatingDTO, GeneralCarRatingDTOPK> {

    @Override
    Optional<GeneralCarRatingDTO> findById(GeneralCarRatingDTOPK generalCarRatingDTOPK);
}

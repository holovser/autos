package diploma.autos.rating.repositories;


import diploma.autos.rating.dto.EngineRatingDTO;
import diploma.autos.rating.dto.EngineRatingDTOPK;
import org.springframework.data.repository.CrudRepository;


public interface EngineRepository extends CrudRepository<EngineRatingDTO, EngineRatingDTOPK> {
    EngineRatingDTO findByBrandAndModelAndVolume(String engineBrand, String engineModel, Double engineVolume);
}

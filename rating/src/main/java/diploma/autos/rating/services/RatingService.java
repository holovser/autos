package diploma.autos.rating.services;

import diploma.autos.rating.dto.EngineRatingDTO;
import diploma.autos.rating.dto.GearboxRatingDTO;
import diploma.autos.rating.exceptions.EngineNotFoundException;
import diploma.autos.rating.exceptions.GearboxNotFoundException;
import diploma.autos.rating.repositories.EngineRepository;
import diploma.autos.rating.repositories.GearboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    EngineRepository engineRepository;
    GearboxRepository gearboxRepository;

    public RatingService( @Autowired EngineRepository engineRepository, @Autowired GearboxRepository gearboxRepository) {
        this.engineRepository = engineRepository;
        this.gearboxRepository = gearboxRepository;
    }

    private int countEngineRating(
            String engineBrand,
            String engineModel,
            Double volume
    ) throws EngineNotFoundException {
        EngineRatingDTO engine =
                engineRepository.findByBrandAndModelAndVolume(engineBrand, engineModel, volume);
        if ( engine == null ) {
            throw new EngineNotFoundException("Your engine not found");
        }

        return engine.getRating();
    }

    private int gearBoxRating(
            String gearboxBrand,
            String gearboxType
    ) throws GearboxNotFoundException {
        GearboxRatingDTO gearbox = gearboxRepository.findByBrandAndType(gearboxBrand, gearboxType);
        if ( gearbox == null ) {
            throw new GearboxNotFoundException("Your gearbox was not found");
        }
        return gearbox.getRating();
    }

    public int countCarRating(
            String carBrand,
            String carModel,
            String engineBrand,
            String engineModel,
            Double engineVolume,
            String gearboxBrand,
            String gearboxModel,
            String gearboxType
    ) throws EngineNotFoundException, GearboxNotFoundException {
        int engineRating = countEngineRating(engineBrand, engineModel, engineVolume);
        int gearboxRating = gearBoxRating(gearboxBrand, gearboxType);
        return engineRating + gearboxRating;
    }


}

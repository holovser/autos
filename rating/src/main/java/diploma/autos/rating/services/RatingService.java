package diploma.autos.rating.services;

import diploma.autos.rating.dto.*;
import diploma.autos.rating.exceptions.EngineNotFoundException;
import diploma.autos.rating.exceptions.GearboxNotFoundException;
import diploma.autos.rating.repositories.EngineRatingRepository;
import diploma.autos.rating.repositories.GearboxRatingRepository;
import diploma.autos.rating.repositories.GeneralCarRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    EngineRatingRepository engineRatingRepository;
    @Autowired
    GearboxRatingRepository gearboxRatingRepository;
    @Autowired
    GeneralCarRatingRepository generalCarRatingRepository;

//    @Autowired
//    public RatingService(
//            EngineRatingRepository engineRatingRepository,
//            GearboxRatingRepository gearboxRatingRepository,
//            GeneralCarRatingRepository generalCarRatingRepository
//    ) {
//        this.engineRatingRepository = engineRatingRepository;
//        this.gearboxRatingRepository = gearboxRatingRepository;
//        this.generalCarRatingRepository = generalCarRatingRepository;
//    }

    // PK stands for primary key
    public <DTO, PK> DTO getRatingObject(CrudRepository repository, PK pk
    ) throws Exception {

        Optional<DTO> dtoOptional = repository.findById(pk);
//        System.out.println(pk.toString());

        if (dtoOptional.isEmpty()) {
            throw new Exception(CrudRepository.class.getName() + " Was not successful in looking for object");
        }
        return dtoOptional.get();
    }

    public double countCarRating(
            String carBrand,
            String carModel,
            String engineBrand,
            String engineModel,
            Double engineVolume,
            String gearboxBrand,
            String gearboxModel,
            String gearboxType
    ) throws Exception {
        GeneralCarRatingDTO generalCarRating =
                this.<GeneralCarRatingDTO, GeneralCarRatingDTOPK>getRatingObject(
                        generalCarRatingRepository,
                        new GeneralCarRatingDTOPK(carBrand, carModel)
                );

        EngineRatingDTO engineRating =
                this.<EngineRatingDTO, EngineRatingDTOPK>getRatingObject(
                        engineRatingRepository,
                        new EngineRatingDTOPK(engineBrand, engineModel, engineVolume)
                );
        GearboxRatingDTO gearboxRating =
                this.<GearboxRatingDTO, GearboxRatingDTOPK>getRatingObject(
                        gearboxRatingRepository,
                        new GearboxRatingDTOPK(gearboxBrand, gearboxModel, gearboxType)
                );

//        System.out.println(generalCarRating.getRating());
//        System.out.println(engineRating.getRating());
//        System.out.println(gearboxRating.getRating());
        return ( generalCarRating.getRating() + engineRating.getRating() + gearboxRating.getRating() ) / 3.0;
    }

}

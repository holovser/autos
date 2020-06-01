package diploma.autos.catalog.services;

import diploma.autos.catalog.dto.AdvertisementDTO;
import diploma.autos.catalog.entities.Advertisement;
import diploma.autos.catalog.entities.Author;
import diploma.autos.catalog.exceptions.NotFoundException;
import diploma.autos.catalog.repositories.AdvertisementDTORepository;
import diploma.autos.catalog.repositories.AdvertisementRepository;
import diploma.autos.catalog.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RetrievingService {

    public RetrievingService() {
    }

    /**
     * Repository for retrieving an persisting  cars
     */
    @Autowired
    CarRepository carRepository;

    /**
     * Repository for retrieving an persisting advertisements
     */
    @Autowired
    AdvertisementRepository advertisementRepository;

    /**
     * Repository for retrieving an persisting  advertisement DTOs
     */
    @Autowired
    AdvertisementDTORepository advertisementDTORepository;


    /**
     *
     * @return all Advertisement DTOs
     */
    public ArrayList<AdvertisementDTO> getAdvsDTO() {
        return (ArrayList<AdvertisementDTO>) advertisementDTORepository.findAll();
    }

    /**
     *
     * @param id advertisement id
     * @return concrete advertisement by it's id
     * @throws Exception
     */
    public Advertisement getAdvByAdvId(Integer id) throws Exception {
        Optional<Advertisement> advOptional = advertisementRepository.findAdvertisementByAdvertisementId(id);
        if ( advOptional.isPresent() ) {
            return advOptional.get();
        } else {
            throw new NotFoundException();
        }
    }


    /**
     *
     * @param id Advertisement id
     * @return Advertisement's author
     * @throws Exception
     */
    public Author getAdvAuthor(Integer id) throws Exception {
        Optional<Advertisement> advOptional = advertisementRepository.findAdvertisementByAdvertisementId(id);

        if ( advOptional.isPresent() && advOptional.get().getAuthor() != null ) {
            return advOptional.get().getAuthor();
        } else {
            throw new NotFoundException();
        }
    }
}

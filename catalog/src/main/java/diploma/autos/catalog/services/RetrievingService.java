package diploma.autos.catalog.services;

import diploma.autos.catalog.dto.AdvertisementDTO;
import diploma.autos.catalog.entities.Advertisement;
import diploma.autos.catalog.entities.Author;
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

    @Autowired
    CarRepository carRepository;

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    AdvertisementDTORepository advertisementDTORepository;


    public ArrayList<AdvertisementDTO> getAdvsDTO() {
        return (ArrayList<AdvertisementDTO>) advertisementDTORepository.findAll();
    }

    public Advertisement getAdvByAdvId(Integer id) throws Exception {
        Optional<Advertisement> advOptional = advertisementRepository.findAdvertisementByAdvertisementId(id);
        if ( advOptional.isPresent() ) {
            return advOptional.get();
        } else {
            throw new Exception("Advertisement not found");
        }
    }

    public Author getAdvAuthor(Integer id) throws Exception {
        Optional<Advertisement> advOptional = advertisementRepository.findAdvertisementByAdvertisementId(id);

        if ( advOptional.isPresent() && advOptional.get().getAuthor() != null ) {
            return advOptional.get().getAuthor();
        } else {
            throw new Exception("Author not found");
        }
    }
}

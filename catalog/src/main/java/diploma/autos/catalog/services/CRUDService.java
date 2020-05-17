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

@Service
public class CRUDService {

    public CRUDService() {
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

    public Advertisement getAdvByAdvId(Integer id) {
        return advertisementRepository.findAdvertisementByAdvertisementId(id);
    }

    public Author getAdvAuthor(Integer id) {
        Advertisement adv = advertisementRepository.findAdvertisementByAdvertisementId(id);
        System.out.println(adv.getAuthor());
        return adv.getAuthor();
    }
}

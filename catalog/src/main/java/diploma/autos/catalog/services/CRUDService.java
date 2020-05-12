package diploma.autos.catalog.services;

import diploma.autos.catalog.repositories.AdvertisementDTORepository;
import diploma.autos.catalog.repositories.AdvertisementRepository;
import diploma.autos.catalog.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CRUDService {

    public CRUDService() {
    }

    @Autowired
    CarRepository carRepository;

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    AdvertisementDTORepository advertisementDTORepository;




}

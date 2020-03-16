package diploma.autos.creation.services;

import diploma.autos.creation.dto.AdvertisementDTO;
import diploma.autos.creation.exceptions.CreateAdvertisementException;
import diploma.autos.creation.repositories.AdvertisementDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAdvertisementService {

    public CreateAdvertisementService() {
    }

    @Autowired
    private AdvertisementDTORepository advRepository;

    public void createAdvertisement(AdvertisementDTO adv) throws CreateAdvertisementException {
        if ( advRepository.findAdvertisementByAdvertisementId(adv.getAdvertisementId()) == null ) {
            advRepository.save(adv);
        } else {
            throw new CreateAdvertisementException("Advertisement already exists");
        }
    }

}

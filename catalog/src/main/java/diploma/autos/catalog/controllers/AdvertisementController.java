package diploma.autos.catalog.controllers;


import diploma.autos.catalog.dto.AdvertisementDTO;
import diploma.autos.catalog.entities.Advertisement;
import diploma.autos.catalog.entities.Author;
import diploma.autos.catalog.entities.Car;
import diploma.autos.catalog.repositories.AdvertisementDTORepository;
import diploma.autos.catalog.repositories.AdvertisementRepository;
import diploma.autos.catalog.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdvertisementController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    AdvertisementRepository advertisementRepository;
    @Autowired
    AdvertisementDTORepository advertisementDTORepository;


    @RequestMapping("/insert")
    public Car insertTestCar() {
        Car tmpCar = new Car();
        tmpCar.setCarId(1);
        tmpCar.setBrand("Toyota");
        tmpCar.setModel("Corolla");

        carRepository.save(tmpCar);

        return tmpCar;
    }

    @RequestMapping("/adv")
    public Iterable<AdvertisementDTO> getAdv() {
        ArrayList<AdvertisementDTO> allAdvs = (ArrayList<AdvertisementDTO>) advertisementDTORepository.findAll();
//        allAdvs.stream().forEach( adv -> adv);
        return allAdvs;
    }


    @RequestMapping("/adv/{id}")
    public Advertisement getAdv(@PathVariable Integer id) {
        Advertisement adv = advertisementRepository.findAdvertisementByAdvertisementId(id);
//        ObjectMapper mapper = new ObjectMapper();

        return adv;
    }

    @RequestMapping("/adv/{id}/author")
    public Author getAuthor(@PathVariable Integer id) {
        Advertisement adv = advertisementRepository.findAdvertisementByAdvertisementId(id);
        System.out.println(adv.getAuthor());
        return adv.getAuthor();
    }

}

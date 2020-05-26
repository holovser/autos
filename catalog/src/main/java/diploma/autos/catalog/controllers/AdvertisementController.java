package diploma.autos.catalog.controllers;


import diploma.autos.catalog.dto.AdvertisementDTO;
import diploma.autos.catalog.entities.Advertisement;
import diploma.autos.catalog.entities.Author;
import diploma.autos.catalog.entities.Car;
import diploma.autos.catalog.repositories.AdvertisementDTORepository;
import diploma.autos.catalog.repositories.AdvertisementRepository;
import diploma.autos.catalog.repositories.CarRepository;
import diploma.autos.catalog.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdvertisementController {

    @Autowired
    CRUDService crudService;

    @Autowired
    CarRepository carRepository;

//    @RequestMapping("/insert")
//    public Car insertTestCar() {
//        Car tmpCar = new Car();
//        tmpCar.setCarId(12);
//        tmpCar.setBrand("1");
//        tmpCar.setModel("2");
//
//        carRepository.save(tmpCar);
//
//        return tmpCar;
//    }

    @RequestMapping("/adv")
    public Iterable<AdvertisementDTO> getAdv() {
        return crudService.getAdvsDTO();
    }


    @RequestMapping("/adv/{id}")
    public Advertisement getAdv(@PathVariable Integer id) {
        return crudService.getAdvByAdvId(id);
//        ObjectMapper mapper = new ObjectMapper();
    }

    @RequestMapping("/adv/{id}/author")
    public Author getAuthor(@PathVariable Integer id) {
        return crudService.getAdvAuthor(id);
    }

}

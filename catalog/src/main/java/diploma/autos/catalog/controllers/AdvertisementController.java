package diploma.autos.catalog.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import diploma.autos.catalog.dto.AdvertisementDTO;
import diploma.autos.catalog.entities.Advertisement;
import diploma.autos.catalog.entities.Author;
import diploma.autos.catalog.exceptions.NotFoundException;
import diploma.autos.catalog.model.AdvsResponse;
import diploma.autos.catalog.repositories.CarRepository;
import diploma.autos.catalog.services.RetrievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Advertisement controller responsible for retrieving advertisements information
 */
@RestController
public class AdvertisementController {


    /**
     *  service which has the main logic of the microservice
     */
    @Autowired
    RetrievingService retrievingService;

    /**
     * Object for serializing other objects
     */
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Constructor set the DateFormat field which solves the problem of converting Timestamp fields
     */
    public AdvertisementController() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm.sss.S");
        mapper.setDateFormat(df);
    }


    /**
     *
     * @return All advertisements
     */
    @GetMapping("/adv")
    public ResponseEntity getAdv() {
        Iterable<AdvertisementDTO> advs;
        String responseJSON = "";
        AdvsResponse advsResponse = new AdvsResponse();
        try {
            advs = retrievingService.getAdvsDTO();
            advsResponse.setAdvs(advs);
            responseJSON = mapper.writeValueAsString(advsResponse);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
    }


    /**
     *
     * @param id  Id of the particular advertisement
     * @return    An advertisement
     */
    @GetMapping("/adv/{id}")
    public ResponseEntity getAdv(@PathVariable Integer id) {
        String responseJSON = "";
        Advertisement adv;

        try {
            adv = retrievingService.getAdvByAdvId(id);
            responseJSON = mapper.writeValueAsString(adv);
        } catch (NotFoundException e) {
            return new ResponseEntity<String>("", null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
    }

    /**
     *
     * @param advId  Id of the particular advertisement
     * @return  Author of the advertisement
     */
    @GetMapping("/adv/{advId}/author")
    public ResponseEntity getAuthor(@PathVariable Integer advId) {
        String responseJSON = "";
        Author author;

        try {
            author = retrievingService.getAdvAuthor(advId);
            responseJSON = mapper.writeValueAsString(author);
        } catch (NotFoundException e) {
            return new ResponseEntity<String>("", null, HttpStatus.NO_CONTENT);
        }  catch (Exception e) {
            System.out.println(e.getClass());
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(responseJSON, null, HttpStatus.OK);
    }
}

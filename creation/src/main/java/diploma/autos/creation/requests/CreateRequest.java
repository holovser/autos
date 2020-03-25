package diploma.autos.creation.requests;

import diploma.autos.creation.dto.*;

public class CreateRequest {
    private AdvertisementDTO adv;
    private CarDTO car;
    private EngineDTO engine;
    private GearboxDTO gearbox;
    private AuthorDTO author;

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public EngineDTO getEngine() {
        return engine;
    }

    public void setEngine(EngineDTO engine) {
        this.engine = engine;
    }

    public GearboxDTO getGearbox() {
        return gearbox;
    }

    public void setGearbox(GearboxDTO gearbox) {
        this.gearbox = gearbox;
    }

    public AdvertisementDTO getAdv() {
        return adv;
    }

    public void setAdv(AdvertisementDTO adv) {
        this.adv = adv;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }
}

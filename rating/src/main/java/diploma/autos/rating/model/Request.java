package diploma.autos.rating.model;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class which represent the request object
 */
public class Request {

    public Request() {
    }

    private String carBrand;
    private String carModel;
    private String engineBrand;
    private String engineModel;
    private Double engineVolume;
    private String gearboxBrand;
    private String gearboxModel;
    private String gearboxType;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getEngineBrand() {
        return engineBrand;
    }

    public void setEngineBrand(String engineBrand) {
        this.engineBrand = engineBrand;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getGearboxBrand() {
        return gearboxBrand;
    }

    public void setGearboxBrand(String gearboxBrand) {
        this.gearboxBrand = gearboxBrand;
    }

    public String getGearboxModel() {
        return gearboxModel;
    }

    public void setGearboxModel(String gearboxModel) {
        this.gearboxModel = gearboxModel;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    @Override
    public String toString() {
        return "Request{" +
                "carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", engineBrand='" + engineBrand + '\'' +
                ", engineModel='" + engineModel + '\'' +
                ", engineVolume=" + engineVolume +
                ", gearboxBrand='" + gearboxBrand + '\'' +
                ", gearboxModel='" + gearboxModel + '\'' +
                ", gearboxType='" + gearboxType + '\'' +
                '}';
    }
}

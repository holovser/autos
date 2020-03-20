package diploma.autos.creation.dto;

import javax.persistence.*;

@Entity
@Table(name = "Car", schema = "catalog", catalog = "")
@IdClass(CarDTOPK.class)
public class CarDTO {
    private int carId;
    private String brand;
    private String model;
    private String gearboxGearboxBrand;
    private String gearboxGearboxModel;
    private String gearboxGearboxType;
    private String engineEngineBrand;
    private String engineEngineModel;
    private double engineEngineVolume;

    @Id
    @Column(name = "carID")
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Id
    @Column(name = "Gearbox_gearbox_brand")
    public String getGearboxGearboxBrand() {
        return gearboxGearboxBrand;
    }

    public void setGearboxGearboxBrand(String gearboxGearboxBrand) {
        this.gearboxGearboxBrand = gearboxGearboxBrand;
    }

    @Id
    @Column(name = "Gearbox_gearbox_model")
    public String getGearboxGearboxModel() {
        return gearboxGearboxModel;
    }

    public void setGearboxGearboxModel(String gearboxGearboxModel) {
        this.gearboxGearboxModel = gearboxGearboxModel;
    }

    @Id
    @Column(name = "Gearbox_gearbox_type")
    public String getGearboxGearboxType() {
        return gearboxGearboxType;
    }

    public void setGearboxGearboxType(String gearboxGearboxType) {
        this.gearboxGearboxType = gearboxGearboxType;
    }

    @Id
    @Column(name = "Engine_engine_brand")
    public String getEngineEngineBrand() {
        return engineEngineBrand;
    }

    public void setEngineEngineBrand(String engineEngineBrand) {
        this.engineEngineBrand = engineEngineBrand;
    }

    @Id
    @Column(name = "Engine_engine_model")
    public String getEngineEngineModel() {
        return engineEngineModel;
    }

    public void setEngineEngineModel(String engineEngineModel) {
        this.engineEngineModel = engineEngineModel;
    }

    @Id
    @Column(name = "Engine_engine_volume")
    public double getEngineEngineVolume() {
        return engineEngineVolume;
    }

    public void setEngineEngineVolume(double engineEngineVolume) {
        this.engineEngineVolume = engineEngineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDTO carDTO = (CarDTO) o;

        if (carId != carDTO.carId) return false;
        if (Double.compare(carDTO.engineEngineVolume, engineEngineVolume) != 0) return false;
        if (brand != null ? !brand.equals(carDTO.brand) : carDTO.brand != null) return false;
        if (model != null ? !model.equals(carDTO.model) : carDTO.model != null) return false;
        if (gearboxGearboxBrand != null ? !gearboxGearboxBrand.equals(carDTO.gearboxGearboxBrand) : carDTO.gearboxGearboxBrand != null)
            return false;
        if (gearboxGearboxModel != null ? !gearboxGearboxModel.equals(carDTO.gearboxGearboxModel) : carDTO.gearboxGearboxModel != null)
            return false;
        if (gearboxGearboxType != null ? !gearboxGearboxType.equals(carDTO.gearboxGearboxType) : carDTO.gearboxGearboxType != null)
            return false;
        if (engineEngineBrand != null ? !engineEngineBrand.equals(carDTO.engineEngineBrand) : carDTO.engineEngineBrand != null)
            return false;
        if (engineEngineModel != null ? !engineEngineModel.equals(carDTO.engineEngineModel) : carDTO.engineEngineModel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = carId;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (gearboxGearboxBrand != null ? gearboxGearboxBrand.hashCode() : 0);
        result = 31 * result + (gearboxGearboxModel != null ? gearboxGearboxModel.hashCode() : 0);
        result = 31 * result + (gearboxGearboxType != null ? gearboxGearboxType.hashCode() : 0);
        result = 31 * result + (engineEngineBrand != null ? engineEngineBrand.hashCode() : 0);
        result = 31 * result + (engineEngineModel != null ? engineEngineModel.hashCode() : 0);
        temp = Double.doubleToLongBits(engineEngineVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

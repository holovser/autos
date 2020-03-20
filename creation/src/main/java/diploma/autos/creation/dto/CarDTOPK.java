package diploma.autos.creation.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CarDTOPK implements Serializable {
    private int carId;
    private String gearboxGearboxBrand;
    private String gearboxGearboxModel;
    private String gearboxGearboxType;
    private String engineEngineBrand;
    private String engineEngineModel;
    private double engineEngineVolume;

    @Column(name = "carID")
    @Id
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Column(name = "Gearbox_gearbox_brand")
    @Id
    public String getGearboxGearboxBrand() {
        return gearboxGearboxBrand;
    }

    public void setGearboxGearboxBrand(String gearboxGearboxBrand) {
        this.gearboxGearboxBrand = gearboxGearboxBrand;
    }

    @Column(name = "Gearbox_gearbox_model")
    @Id
    public String getGearboxGearboxModel() {
        return gearboxGearboxModel;
    }

    public void setGearboxGearboxModel(String gearboxGearboxModel) {
        this.gearboxGearboxModel = gearboxGearboxModel;
    }

    @Column(name = "Gearbox_gearbox_type")
    @Id
    public String getGearboxGearboxType() {
        return gearboxGearboxType;
    }

    public void setGearboxGearboxType(String gearboxGearboxType) {
        this.gearboxGearboxType = gearboxGearboxType;
    }

    @Column(name = "Engine_engine_brand")
    @Id
    public String getEngineEngineBrand() {
        return engineEngineBrand;
    }

    public void setEngineEngineBrand(String engineEngineBrand) {
        this.engineEngineBrand = engineEngineBrand;
    }

    @Column(name = "Engine_engine_model")
    @Id
    public String getEngineEngineModel() {
        return engineEngineModel;
    }

    public void setEngineEngineModel(String engineEngineModel) {
        this.engineEngineModel = engineEngineModel;
    }

    @Column(name = "Engine_engine_volume")
    @Id
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

        CarDTOPK carDTOPK = (CarDTOPK) o;

        if (carId != carDTOPK.carId) return false;
        if (Double.compare(carDTOPK.engineEngineVolume, engineEngineVolume) != 0) return false;
        if (gearboxGearboxBrand != null ? !gearboxGearboxBrand.equals(carDTOPK.gearboxGearboxBrand) : carDTOPK.gearboxGearboxBrand != null)
            return false;
        if (gearboxGearboxModel != null ? !gearboxGearboxModel.equals(carDTOPK.gearboxGearboxModel) : carDTOPK.gearboxGearboxModel != null)
            return false;
        if (gearboxGearboxType != null ? !gearboxGearboxType.equals(carDTOPK.gearboxGearboxType) : carDTOPK.gearboxGearboxType != null)
            return false;
        if (engineEngineBrand != null ? !engineEngineBrand.equals(carDTOPK.engineEngineBrand) : carDTOPK.engineEngineBrand != null)
            return false;
        if (engineEngineModel != null ? !engineEngineModel.equals(carDTOPK.engineEngineModel) : carDTOPK.engineEngineModel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = carId;
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

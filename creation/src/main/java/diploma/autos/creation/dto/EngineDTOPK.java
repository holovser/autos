package diploma.autos.creation.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EngineDTOPK implements Serializable {
    private String engineBrand;
    private String engineModel;
    private double engineVolume;

    @Column(name = "engine_brand")
    @Id
    public String getEngineBrand() {
        return engineBrand;
    }

    public void setEngineBrand(String engineBrand) {
        this.engineBrand = engineBrand;
    }

    @Column(name = "engine_model")
    @Id
    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    @Column(name = "engine_volume")
    @Id
    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EngineDTOPK that = (EngineDTOPK) o;

        if (Double.compare(that.engineVolume, engineVolume) != 0) return false;
        if (engineBrand != null ? !engineBrand.equals(that.engineBrand) : that.engineBrand != null) return false;
        if (engineModel != null ? !engineModel.equals(that.engineModel) : that.engineModel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = engineBrand != null ? engineBrand.hashCode() : 0;
        result = 31 * result + (engineModel != null ? engineModel.hashCode() : 0);
        temp = Double.doubleToLongBits(engineVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

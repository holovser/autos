package diploma.autos.creation.dto;

import javax.persistence.*;

@Entity
@Table(name = "Engine", schema = "catalog", catalog = "")
@IdClass(EngineDTOPK.class)
public class EngineDTO {
    private String engineBrand;
    private String engineModel;
    private double engineVolume;

    @Id
    @Column(name = "engine_brand")
    public String getEngineBrand() {
        return engineBrand;
    }

    public void setEngineBrand(String engineBrand) {
        this.engineBrand = engineBrand;
    }

    @Id
    @Column(name = "engine_model")
    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    @Id
    @Column(name = "engine_volume")
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

        EngineDTO engineDTO = (EngineDTO) o;

        if (Double.compare(engineDTO.engineVolume, engineVolume) != 0) return false;
        if (engineBrand != null ? !engineBrand.equals(engineDTO.engineBrand) : engineDTO.engineBrand != null)
            return false;
        if (engineModel != null ? !engineModel.equals(engineDTO.engineModel) : engineDTO.engineModel != null)
            return false;

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

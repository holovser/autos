package diploma.autos.rating.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GeneralCarRatingDTOPK implements Serializable {
    private String carBrand;
    private String carModel;

    public GeneralCarRatingDTOPK() {
    }

    public GeneralCarRatingDTOPK(String carBrand, String carModel) {
        this.carBrand = carBrand;
        this.carModel = carModel;
    }

    @Column(name = "car_brand")
    @Id
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @Column(name = "car_model")
    @Id
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralCarRatingDTOPK that = (GeneralCarRatingDTOPK) o;

        if (carBrand != null ? !carBrand.equals(that.carBrand) : that.carBrand != null) return false;
        if (carModel != null ? !carModel.equals(that.carModel) : that.carModel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carBrand != null ? carBrand.hashCode() : 0;
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        return result;
    }
}

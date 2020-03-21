package diploma.autos.rating.dto;

import javax.persistence.*;

@Entity
@Table(name = "General_car_rating", schema = "rating", catalog = "")
@IdClass(GeneralCarRatingDTOPK.class)
public class GeneralCarRatingDTO {
    private String carBrand;
    private String carModel;
    private Integer rating;

    @Id
    @Column(name = "car_brand")
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    @Id
    @Column(name = "car_model")
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralCarRatingDTO that = (GeneralCarRatingDTO) o;

        if (carBrand != null ? !carBrand.equals(that.carBrand) : that.carBrand != null) return false;
        if (carModel != null ? !carModel.equals(that.carModel) : that.carModel != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carBrand != null ? carBrand.hashCode() : 0;
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}

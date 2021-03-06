package diploma.autos.rating.dto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Gearbox_rating", schema = "rating", catalog = "")
@IdClass(GearboxRatingDTOPK.class)
public class GearboxRatingDTO {
    private String brand;
    private String type;
    private Integer rating;
    private String model;

    public GearboxRatingDTO(String brand, String type, Integer rating, String model) {
        this.brand = brand;
        this.type = type;
        this.rating = rating;
        this.model = model;
    }


    public GearboxRatingDTO() {
    }

    @Id
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Id
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Id
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GearboxRatingDTO that = (GearboxRatingDTO) o;
        return rating == that.rating &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(type, that.type) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, type, rating, model);
    }
}

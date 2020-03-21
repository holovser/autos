package diploma.autos.rating.dto;

import javax.persistence.*;

@Entity
@Table(name = "Gearbox_rating", schema = "rating", catalog = "")
@IdClass(GearboxRatingDTOPK.class)
public class GearboxRatingDTO {
    private String brand;
    private String type;
    private int rating;
    private String model;

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
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
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

        if (rating != that.rating) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}

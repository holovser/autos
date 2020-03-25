package diploma.autos.rating.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GearboxRatingDTOPK implements Serializable {
    private String brand;
    private String type;
    private String model;

    public GearboxRatingDTOPK() {
    }

    public GearboxRatingDTOPK(String brand, String model,  String type) {
        this.brand = brand;
        this.type = type;
        this.model = model;
    }

    @Column(name = "brand")
    @Id
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "type")
    @Id
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "model")
    @Id
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
        GearboxRatingDTOPK that = (GearboxRatingDTOPK) o;
        return Objects.equals(brand, that.brand) &&
                Objects.equals(type, that.type) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, type, model);
    }

    @Override
    public String toString() {
        return "GearboxRatingDTOPK{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

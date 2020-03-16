package diploma.autos.rating.entities;

import javax.persistence.*;

@Entity
@IdClass(GearboxPK.class)
public class Gearbox {
    private String brand;
    private String type;
    private int value;

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
    @Column(name = "value")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gearbox gearbox = (Gearbox) o;

        if (value != gearbox.value) return false;
        if (brand != null ? !brand.equals(gearbox.brand) : gearbox.brand != null) return false;
        if (type != null ? !type.equals(gearbox.type) : gearbox.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + value;
        return result;
    }
}

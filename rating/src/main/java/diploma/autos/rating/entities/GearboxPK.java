package diploma.autos.rating.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GearboxPK implements Serializable {
    private String brand;
    private String type;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GearboxPK gearboxPK = (GearboxPK) o;

        if (brand != null ? !brand.equals(gearboxPK.brand) : gearboxPK.brand != null) return false;
        if (type != null ? !type.equals(gearboxPK.type) : gearboxPK.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}

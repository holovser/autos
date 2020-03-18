package diploma.autos.rating.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EnginePK implements Serializable {
    private String brand;
    private String model;
    private double volume;

    @Column(name = "brand")
    @Id
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model")
    @Id
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "volume")
    @Id
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnginePK enginePK = (EnginePK) o;

        if (Double.compare(enginePK.volume, volume) != 0) return false;
        if (brand != null ? !brand.equals(enginePK.brand) : enginePK.brand != null) return false;
        if (model != null ? !model.equals(enginePK.model) : enginePK.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

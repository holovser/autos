package diploma.autos.rating.entities;

import javax.persistence.*;

@Entity
@IdClass(EnginePK.class)
public class Engine {
    private String brand;
    private String model;
    private double volume;
    private Integer value;

    @Id
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Id
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Id
    @Column(name = "volume")
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Basic
    @Column(name = "value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (Double.compare(engine.volume, volume) != 0) return false;
        if (brand != null ? !brand.equals(engine.brand) : engine.brand != null) return false;
        if (model != null ? !model.equals(engine.model) : engine.model != null) return false;
        if (value != null ? !value.equals(engine.value) : engine.value != null) return false;

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
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}

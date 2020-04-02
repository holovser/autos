package diploma.autos.similarity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @Column(name = "carID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "mileage")
    public Integer mileage;

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public int getCarId() {
        return carId;
    }

    @JsonIgnore
    @OneToOne(mappedBy = "car", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Advertisement adv;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(
                    name = "Engine_engine_brand",
                    referencedColumnName = "engine_brand"),
            @JoinColumn(
                    name = "Engine_engine_model",
                    referencedColumnName = "engine_model"),
            @JoinColumn(
                    name = "Engine_engine_volume",
                    referencedColumnName = "engine_volume")
    })
    private Engine engine;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(
                    name = "Gearbox_gearbox_brand",
                    referencedColumnName = "gearbox_brand"),

            @JoinColumn(
                    name = "Gearbox_gearbox_model",
                    referencedColumnName = "gearbox_model"),
            @JoinColumn(
                    name = "Gearbox_gearbox_type",
                    referencedColumnName = "gearbox_type")
    })
    private Gearbox gearbox;

    public void setCarId(int carId) {
        this.carId = carId;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Advertisement getAdv() {
        return adv;
    }

    public void setAdv(Advertisement adv) {
        this.adv = adv;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}

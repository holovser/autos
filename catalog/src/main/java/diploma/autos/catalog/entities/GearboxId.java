package diploma.autos.creation.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class GearboxId implements Serializable {

    @Column(name = "gearbox_brand")
    private String gearboxBrand;

    @Column(name = "gearbox_model")
    private String gearboxModel;

    @Column(name = "gearbox_type")
    private String gearboxType;

    public String getGearboxBrand() {
        return gearboxBrand;
    }

    public void setGearboxBrand(String gearboxBrand) {
        this.gearboxBrand = gearboxBrand;
    }

    public String getGearboxModel() {
        return gearboxModel;
    }

    public void setGearboxModel(String gearboxModel) {
        this.gearboxModel = gearboxModel;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }
}

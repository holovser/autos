package diploma.autos.creation.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GearboxDTOPK implements Serializable {
    private String gearboxBrand;
    private String gearboxModel;
    private String gearboxType;

    @Column(name = "gearbox_brand")
    @Id
    public String getGearboxBrand() {
        return gearboxBrand;
    }

    public void setGearboxBrand(String gearboxBrand) {
        this.gearboxBrand = gearboxBrand;
    }

    @Column(name = "gearbox_model")
    @Id
    public String getGearboxModel() {
        return gearboxModel;
    }

    public void setGearboxModel(String gearboxModel) {
        this.gearboxModel = gearboxModel;
    }

    @Column(name = "gearbox_type")
    @Id
    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GearboxDTOPK that = (GearboxDTOPK) o;

        if (gearboxBrand != null ? !gearboxBrand.equals(that.gearboxBrand) : that.gearboxBrand != null) return false;
        if (gearboxModel != null ? !gearboxModel.equals(that.gearboxModel) : that.gearboxModel != null) return false;
        if (gearboxType != null ? !gearboxType.equals(that.gearboxType) : that.gearboxType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gearboxBrand != null ? gearboxBrand.hashCode() : 0;
        result = 31 * result + (gearboxModel != null ? gearboxModel.hashCode() : 0);
        result = 31 * result + (gearboxType != null ? gearboxType.hashCode() : 0);
        return result;
    }
}

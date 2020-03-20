package diploma.autos.creation.dto;

import javax.persistence.*;

@Entity
@Table(name = "Gearbox", schema = "catalog", catalog = "")
@IdClass(GearboxDTOPK.class)
public class GearboxDTO {
    private String gearboxBrand;
    private String gearboxModel;
    private String gearboxType;

    @Id
    @Column(name = "gearbox_brand")
    public String getGearboxBrand() {
        return gearboxBrand;
    }

    public void setGearboxBrand(String gearboxBrand) {
        this.gearboxBrand = gearboxBrand;
    }

    @Id
    @Column(name = "gearbox_model")
    public String getGearboxModel() {
        return gearboxModel;
    }

    public void setGearboxModel(String gearboxModel) {
        this.gearboxModel = gearboxModel;
    }

    @Id
    @Column(name = "gearbox_type")
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

        GearboxDTO that = (GearboxDTO) o;

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

package diploma.autos.catalog.model;

import diploma.autos.catalog.dto.AdvertisementDTO;



public class AdvsResponse {

    private Iterable<AdvertisementDTO> advs;

    public AdvsResponse() {
    }

    public Iterable<AdvertisementDTO> getAdvs() {
        return advs;
    }

    public void setAdvs(Iterable<AdvertisementDTO> advs) {
        this.advs = advs;
    }
}

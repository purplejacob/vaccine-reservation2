package vaccinereservation;

import java.util.Date;

public class CancelCompleted extends AbstractEvent {

    private Long id;
    private String reservationid;
    private String vaccinetype;
    private Integer qty;
    private Date shelflife;
    private Date productiondate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getReservationid() {
        return reservationid;
    }

    public void setReservationid(String reservationid) {
        this.reservationid = reservationid;
    }
    public String getVaccinetype() {
        return vaccinetype;
    }

    public void setVaccinetype(String vaccinetype) {
        this.vaccinetype = vaccinetype;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public Date getShelflife() {
        return shelflife;
    }

    public void setShelflife(Date shelflife) {
        this.shelflife = shelflife;
    }
    public Date getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(Date productiondate) {
        this.productiondate = productiondate;
    }
}
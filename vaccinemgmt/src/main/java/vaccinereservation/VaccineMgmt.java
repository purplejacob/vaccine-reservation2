package vaccinereservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="VaccineMgmt_table")
public class VaccineMgmt {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String reservationid;
    private String vaccinetype;
    private Integer qty;
    private Date shelflife;
    private Date productiondate;

    @PostPersist
    public void onPostPersist(){
        ReservationCompleted reservationCompleted = new ReservationCompleted();
        BeanUtils.copyProperties(this, reservationCompleted);
        reservationCompleted.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){
        CancelCompleted cancelCompleted = new CancelCompleted();
        BeanUtils.copyProperties(this, cancelCompleted);
        cancelCompleted.publishAfterCommit();

    }

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
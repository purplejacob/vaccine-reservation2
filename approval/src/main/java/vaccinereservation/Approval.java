package vaccinereservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Approval_table")
public class Approval {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String reservationid;
    private String status;

    @PostPersist
    public void onPostPersist(){
        ApprovalFinished approvalFinished = new ApprovalFinished();
        BeanUtils.copyProperties(this, approvalFinished);
        approvalFinished.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){
        ApprovalDenied approvalDenied = new ApprovalDenied();
        BeanUtils.copyProperties(this, approvalDenied);
        approvalDenied.publishAfterCommit();

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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
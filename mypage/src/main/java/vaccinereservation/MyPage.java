package vaccinereservation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MyPage_table")
public class MyPage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long customerid;
        private Long hospitalid;
        private String date;
        private String vaccinetype;
        private String status;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getCustomerid() {
            return customerid;
        }

        public void setCustomerid(Long customerid) {
            this.customerid = customerid;
        }
        public Long getHospitalid() {
            return hospitalid;
        }

        public void setHospitalid(Long hospitalid) {
            this.hospitalid = hospitalid;
        }
        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
        public String getVaccinetype() {
            return vaccinetype;
        }

        public void setVaccinetype(String vaccinetype) {
            this.vaccinetype = vaccinetype;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

}

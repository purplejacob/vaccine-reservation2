package vaccinereservation;

import vaccinereservation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired VaccineMgmtRepository vaccineMgmtRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverApprovalFinished_CheckReservation(@Payload ApprovalFinished approvalFinished){

        if(!approvalFinished.validate()) return;

        System.out.println("\n\n##### listener CheckReservation : " + approvalFinished.toJson() + "\n\n");



        // Sample Logic //
        // VaccineMgmt vaccineMgmt = new VaccineMgmt();
        // vaccineMgmtRepository.save(vaccineMgmt);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_CancelReservation(@Payload ReservationCanceled reservationCanceled){

        if(!reservationCanceled.validate()) return;

        System.out.println("\n\n##### listener CancelReservation : " + reservationCanceled.toJson() + "\n\n");



        // Sample Logic //
        // VaccineMgmt vaccineMgmt = new VaccineMgmt();
        // vaccineMgmtRepository.save(vaccineMgmt);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}

package vaccinereservation;

import vaccinereservation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyPageViewHandler {


    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationPlaced_then_CREATE_1 (@Payload ReservationPlaced reservationPlaced) {
        try {

            if (!reservationPlaced.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setId(reservationPlaced.getId());
            myPage.setCustomerid(reservationPlaced.getCustomerid());
            myPage.setHospitalid(reservationPlaced.getHospitalid());
            myPage.setDate(reservationPlaced.getDate());
            myPage.setStatus(reservationPlaced.getStatus());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCompleted_then_UPDATE_1(@Payload ReservationCompleted reservationCompleted) {
        try {
            if (!reservationCompleted.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(reservationCompleted.getReservationid());

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 myPage.setVaccinetype(reservationCompleted.getVaccinetype());
                 myPage.setStatus("VaccineMatched");
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCancelCompleted_then_UPDATE_2(@Payload CancelCompleted cancelCompleted) {
        try {
            if (!cancelCompleted.validate()) return;
                // view 객체 조회
            Optional<MyPage> myPageOptional = myPageRepository.findById(cancelCompleted.getReservationid());

            if( myPageOptional.isPresent()) {
                 MyPage myPage = myPageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                 myPage.setVaccinetype(null);
                // view 레파지 토리에 save
                 myPageRepository.save(myPage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


package fd.infra;

import fd.domain.*;
import fd.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class KakaotalkViewHandler {

    @Autowired
    private KakaotalkRepository kakaotalkRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCreated_then_CREATE_1 (@Payload OrderCreated orderCreated) {
        try {

            if (!orderCreated.validate()) return;

            // view 객체 생성
            Kakaotalk kakaotalk = new Kakaotalk();
            // view 객체에 이벤트의 Value 를 set 함
            kakaotalk.setOrderStatus(String.valueOf(orderCreated.getId()));
            // view 레파지 토리에 save
            kakaotalkRepository.save(kakaotalk);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_UPDATE_1(@Payload OrderPlaced orderPlaced) {
        try {
            if (!orderPlaced.validate()) return;
                // view 객체 조회

                List<Kakaotalk> kakaotalkList = kakaotalkRepository.findByPhoneNumber(String.valueOf(orderPlaced.getId()));
                for(Kakaotalk kakaotalk : kakaotalkList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                kakaotalkRepository.save(kakaotalk);
                }

                List<Kakaotalk> kakaotalkList = kakaotalkRepository.findByUserId(String.valueOf(orderPlaced.getId()));
                for(Kakaotalk kakaotalk : kakaotalkList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                kakaotalkRepository.save(kakaotalk);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDepartedDelivery_then_UPDATE_2(@Payload DepartedDelivery departedDelivery) {
        try {
            if (!departedDelivery.validate()) return;
                // view 객체 조회
            Optional<Kakaotalk> kakaotalkOptional = kakaotalkRepository.findById(departedDelivery.getId());

            if( kakaotalkOptional.isPresent()) {
                 Kakaotalk kakaotalk = kakaotalkOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                kakaotalk.setOrderStatus(String.valueOf(departedDelivery.getDeliveryStatus()));    
                // view 레파지 토리에 save
                 kakaotalkRepository.save(kakaotalk);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when배달완료됨_then_UPDATE_3(@Payload 배달완료됨 배달완료됨) {
        try {
            if (!배달완료됨.validate()) return;
                // view 객체 조회
            Optional<Kakaotalk> kakaotalkOptional = kakaotalkRepository.findById(배달완료됨.getId());

            if( kakaotalkOptional.isPresent()) {
                 Kakaotalk kakaotalk = kakaotalkOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                kakaotalk.setOrderStatus(String.valueOf(배달완료됨.getDeliveryStatus()));    
                // view 레파지 토리에 save
                 kakaotalkRepository.save(kakaotalk);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_4(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회
            Optional<Kakaotalk> kakaotalkOptional = kakaotalkRepository.findById(orderCanceled.getId());

            if( kakaotalkOptional.isPresent()) {
                 Kakaotalk kakaotalk = kakaotalkOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                kakaotalk.setOrderStatus(orderCanceled.getOrderStatus());    
                // view 레파지 토리에 save
                 kakaotalkRepository.save(kakaotalk);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_DELETE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            kakaotalkRepository.deleteById(orderCanceled.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


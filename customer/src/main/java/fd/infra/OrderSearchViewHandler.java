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
public class OrderSearchViewHandler {

    @Autowired
    private OrderSearchRepository orderSearchRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCreated_then_CREATE_1 (@Payload OrderCreated orderCreated) {
        try {

            if (!orderCreated.validate()) return;

            // view 객체 생성
            OrderSearch orderSearch = new OrderSearch();
            // view 객체에 이벤트의 Value 를 set 함
            orderSearch.setOrderStatus(orderCreated.getOrderStatus());
            // view 레파지 토리에 save
            orderSearchRepository.save(orderSearch);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_UPDATE_1(@Payload OrderPlaced orderPlaced) {
        try {
            if (!orderPlaced.validate()) return;
                // view 객체 조회
            Optional<OrderSearch> orderSearchOptional = orderSearchRepository.findById(orderPlaced.getId());

            if( orderSearchOptional.isPresent()) {
                 OrderSearch orderSearch = orderSearchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderSearch.setOrderStatus(orderPlaced.getOderStatus());    
                // view 레파지 토리에 save
                 orderSearchRepository.save(orderSearch);
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
            Optional<OrderSearch> orderSearchOptional = orderSearchRepository.findById(departedDelivery.getId());

            if( orderSearchOptional.isPresent()) {
                 OrderSearch orderSearch = orderSearchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderSearch.setOrderStatus(String.valueOf(departedDelivery.getDeliveryStatus()));    
                // view 레파지 토리에 save
                 orderSearchRepository.save(orderSearch);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_3(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            if (!deliveryCanceled.validate()) return;
                // view 객체 조회
            Optional<OrderSearch> orderSearchOptional = orderSearchRepository.findById(deliveryCanceled.getId());

            if( orderSearchOptional.isPresent()) {
                 OrderSearch orderSearch = orderSearchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderSearch.setOrderStatus(String.valueOf(deliveryCanceled.getIsDelivered()));    
                // view 레파지 토리에 save
                 orderSearchRepository.save(orderSearch);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void when배달완료됨_then_UPDATE_4(@Payload 배달완료됨 배달완료됨) {
        try {
            if (!배달완료됨.validate()) return;
                // view 객체 조회
            Optional<OrderSearch> orderSearchOptional = orderSearchRepository.findById(배달완료됨.getId());

            if( orderSearchOptional.isPresent()) {
                 OrderSearch orderSearch = orderSearchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderSearch.setOrderStatus(String.valueOf(배달완료됨.getDeliveryStatus()));    
                // view 레파지 토리에 save
                 orderSearchRepository.save(orderSearch);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_5(@Payload Paid paid) {
        try {
            if (!paid.validate()) return;
                // view 객체 조회
            Optional<OrderSearch> orderSearchOptional = orderSearchRepository.findById(paid.getId());

            if( orderSearchOptional.isPresent()) {
                 OrderSearch orderSearch = orderSearchOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                 orderSearchRepository.save(orderSearch);
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
            orderSearchRepository.deleteById(orderCanceled.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


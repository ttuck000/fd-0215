package fd.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fd.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fd.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='요리완료됨'")
    public void whenever요리완료됨_배달요청(@Payload 요리완료됨 요리완료됨){

        요리완료됨 event = 요리완료됨;
        System.out.println("\n\n##### listener 배달요청 : " + 요리완료됨 + "\n\n");


        

        // Sample Logic //
        Delivery.배달요청(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancellationReceived'")
    public void wheneverOrderCancellationReceived_배달취소(@Payload OrderCancellationReceived orderCancellationReceived){

        OrderCancellationReceived event = orderCancellationReceived;
        System.out.println("\n\n##### listener 배달취소 : " + orderCancellationReceived + "\n\n");


        

        // Sample Logic //
        Delivery.배달취소(event);
        

        

    }

}



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
    @Autowired OrderRepository orderRepository;
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='품절처리됨'")
    public void whenever품절처리됨_품절처리도착(@Payload 품절처리됨 품절처리됨){

        품절처리됨 event = 품절처리됨;
        System.out.println("\n\n##### listener 품절처리도착 : " + 품절처리됨 + "\n\n");


        

        // Sample Logic //
        Payment.품절처리도착(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancellationReceived'")
    public void wheneverOrderCancellationReceived_품절처리도착(@Payload OrderCancellationReceived orderCancellationReceived){

        OrderCancellationReceived event = orderCancellationReceived;
        System.out.println("\n\n##### listener 품절처리도착 : " + orderCancellationReceived + "\n\n");


        

        // Sample Logic //
        Payment.품절처리도착(event);
        

        

    }


}



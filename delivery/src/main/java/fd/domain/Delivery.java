package fd.domain;

import fd.domain.DepartedDelivery;
import fd.domain.DeliveryCanceled;
import fd.domain.배달완료됨;
import fd.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String adderess;
    
    
    
    
    
    private String customerName;
    
    
    
    
    
    private Integer deliveryStatus;
    
    
    
    
    
    private String customerPhnum;

    @PostPersist
    public void onPostPersist(){


        DepartedDelivery departedDelivery = new DepartedDelivery(this);
        departedDelivery.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(this);
        deliveryCanceled.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        fd.external.Review review = new fd.external.Review();
        // mappings goes here
        DeliveryApplication.applicationContext.getBean(fd.external.ReviewService.class)
            .writereview(review);


        배달완료됨 배달완료됨 = new 배달완료됨(this);
        배달완료됨.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void 배달요청(요리완료됨 요리완료됨){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(요리완료됨.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void 배달취소(OrderCancellationReceived orderCancellationReceived){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancellationReceived.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}

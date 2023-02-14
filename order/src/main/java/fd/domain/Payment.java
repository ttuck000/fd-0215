package fd.domain;

import fd.domain.Paid;
import fd.domain.CancelPayment;
import fd.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Payment_table")
@Data

public class Payment  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer amount;
    
    
    
    
    
    private Integer orderid;

    @PrePersist
    public void onPrePersist(){


        Paid paid = new Paid(this);
        paid.publishAfterCommit();



        CancelPayment cancelPayment = new CancelPayment(this);
        cancelPayment.publishAfterCommit();

    }

    public static PaymentRepository repository(){
        PaymentRepository paymentRepository = OrderApplication.applicationContext.getBean(PaymentRepository.class);
        return paymentRepository;
    }




    public static void 품절처리도착(품절처리됨 품절처리됨){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(품절처리됨.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

        
    }
    public static void 품절처리도착(OrderCancellationReceived orderCancellationReceived){

        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancellationReceived.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

        
    }


}

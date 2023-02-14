package fd.domain;

import fd.domain.OrderCreated;
import fd.domain.OrderCanceled;
import fd.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String userid;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String menuid;
    
    
    
    
    
    private String storeid;
    
    
    
    
    
    private Integer quantity;
    
    
    
    
    
    private String orderStatus;

    @PrePersist
    public void onPrePersist(){


        OrderCreated orderCreated = new OrderCreated(this);
        orderCreated.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}

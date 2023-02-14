package fd.domain;

import fd.domain.OrderCancellationArrived;
import fd.domain.요리완료됨;
import fd.domain.OrderPlaced;
import fd.domain.주문접수됨;
import fd.domain.품절처리됨;
import fd.domain.OrderCancellationReceived;
import fd.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="OrderManagement_table")
@Data

public class OrderManagement  {


    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customername;
    
    
    
    
    
    private String customerphnum;
    
    
    
    
    
    private String menuid;
    
    
    
    
    
    private Integer quantity;
    
    
    
    
    
    private String oderStatus;

    @PostPersist
    public void onPostPersist(){


        OrderCancellationArrived orderCancellationArrived = new OrderCancellationArrived(this);
        orderCancellationArrived.publishAfterCommit();



        요리완료됨 요리완료됨 = new 요리완료됨(this);
        요리완료됨.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();



        주문접수됨 주문접수됨 = new 주문접수됨(this);
        주문접수됨.publishAfterCommit();



        품절처리됨 품절처리됨 = new 품절처리됨(this);
        품절처리됨.publishAfterCommit();



        OrderCancellationReceived orderCancellationReceived = new OrderCancellationReceived(this);
        orderCancellationReceived.publishAfterCommit();

    }

    public static OrderManagementRepository repository(){
        OrderManagementRepository orderManagementRepository = StoreApplication.applicationContext.getBean(OrderManagementRepository.class);
        return orderManagementRepository;
    }






}

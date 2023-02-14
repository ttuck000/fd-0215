package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCancellationArrived extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String oderStatus;

    public OrderCancellationArrived(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderCancellationArrived(){
        super();
    }
}

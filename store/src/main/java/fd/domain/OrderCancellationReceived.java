package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCancellationReceived extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String oderStatus;

    public OrderCancellationReceived(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderCancellationReceived(){
        super();
    }
}

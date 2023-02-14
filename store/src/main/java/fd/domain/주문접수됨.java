package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class 주문접수됨 extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String oderStatus;

    public 주문접수됨(OrderManagement aggregate){
        super(aggregate);
    }
    public 주문접수됨(){
        super();
    }
}

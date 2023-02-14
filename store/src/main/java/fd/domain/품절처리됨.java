package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class 품절처리됨 extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String oderStatus;

    public 품절처리됨(OrderManagement aggregate){
        super(aggregate);
    }
    public 품절처리됨(){
        super();
    }
}

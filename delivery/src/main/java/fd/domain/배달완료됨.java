package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class 배달완료됨 extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Integer deliveryStatus;

    public 배달완료됨(Delivery aggregate){
        super(aggregate);
    }
    public 배달완료됨(){
        super();
    }
}

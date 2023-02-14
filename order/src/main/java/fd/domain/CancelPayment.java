package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CancelPayment extends AbstractEvent {

    private Long id;
    private Integer amount;
    private Integer orderid;

    public CancelPayment(Payment aggregate){
        super(aggregate);
    }
    public CancelPayment(){
        super();
    }
}

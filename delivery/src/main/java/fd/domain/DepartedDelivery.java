package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DepartedDelivery extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String adderess;
    private String customerName;
    private String customerPhnum;
    private Integer deliveryStatus;

    public DepartedDelivery(Delivery aggregate){
        super(aggregate);
    }
    public DepartedDelivery(){
        super();
    }
}

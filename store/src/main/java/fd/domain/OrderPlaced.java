package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String customername;
    private String customerphnum;
    private String menuid;
    private Integer quantity;
    private String oderStatus;

    public OrderPlaced(OrderManagement aggregate){
        super(aggregate);
    }
    public OrderPlaced(){
        super();
    }
}

package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCreated extends AbstractEvent {

    private Long id;
    private String userid;
    private String address;
    private String menuid;
    private String storeid;
    private Integer quantity;
    private String orderStatus;

    public OrderCreated(Order aggregate){
        super(aggregate);
    }
    public OrderCreated(){
        super();
    }
}

package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class 요리완료됨 extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String customername;
    private String customerphnum;
    private String menuid;
    private Integer quantity;
    private String oderStatus;

    public 요리완료됨(OrderManagement aggregate){
        super(aggregate);
    }
    public 요리완료됨(){
        super();
    }
}

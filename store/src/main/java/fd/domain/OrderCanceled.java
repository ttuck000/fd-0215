package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String userid;
    private String address;
    private String menuid;
    private String storeid;
    private Integer quantity;
    private String orderStatus;
}



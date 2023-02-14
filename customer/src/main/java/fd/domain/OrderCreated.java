package fd.domain;

import fd.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderCreated extends AbstractEvent {

    private Long id;
    private String Userid;
    private String Address;
    private String Menuid;
    private String Storeid;
    private Integer Quantity;
    private String Order Status;
}

package fd.domain;

import fd.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long orderID;
    private String address;
    private String customername;
    private String customerphnum;
    private String menuid;
    private Integer Quantity;
    private String OderStatus;
}

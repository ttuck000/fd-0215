package fd.domain;

import fd.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DepartedDelivery extends AbstractEvent {

    private Long id;
    private Long orderID;
    private String adderess;
    private String customerName;
    private String customerPhnum;
    private Integer deliveryStatus;
}

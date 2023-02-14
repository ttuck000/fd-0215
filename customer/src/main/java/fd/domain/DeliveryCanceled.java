package fd.domain;

import fd.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private Long orderID;
    private Boolean isDelivered;
}

package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCancellationReceived extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String oderStatus;
}



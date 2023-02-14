package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class 품절처리됨 extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String oderStatus;
}



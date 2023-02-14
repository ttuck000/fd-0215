package fd.domain;

import fd.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class 배달완료됨 extends AbstractEvent {

    private Long id;
    private Long orderID;
    private Integer deliveryStatus;
}

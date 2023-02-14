package fd.domain;

import fd.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Paid extends AbstractEvent {

    private Long id;
    private Integer Amount;
    private Integer Orderid;
}

package fd.domain;

import fd.domain.*;
import fd.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Paid extends AbstractEvent {

    private Long id;
    private Integer amount;
    private Integer orderid;
}



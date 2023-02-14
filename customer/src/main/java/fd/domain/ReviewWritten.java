package fd.domain;

import fd.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class ReviewWritten extends AbstractEvent {

    private Long id;
    private String contents;
    private String content;
    private String userId;
    private String storeId;
    private String menu;
}

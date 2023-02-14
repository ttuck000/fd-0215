package fd.external;

import lombok.Data;
import java.util.Date;
@Data
public class Review {

    private Long id;
    private String content;
    private String userId;
    private String storeId;
    private String menu;
}



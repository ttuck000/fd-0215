package fd.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="ReviewSearch_table")
@Data
public class ReviewSearch {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String reviewId;
        private String contents;
        private String customerId;


}

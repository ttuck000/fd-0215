package fd.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="Kakaotalk_table")
@Data
public class Kakaotalk {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderStatus;
        private String phoneNumber;
        private String userId;


}

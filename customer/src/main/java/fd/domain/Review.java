package fd.domain;

import fd.domain.ReviewWritten;
import fd.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Review_table")
@Data

public class Review  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String content;
    
    
    
    
    
    private String userId;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String menu;

    @PrePersist
    public void onPrePersist(){


        ReviewWritten reviewWritten = new ReviewWritten(this);
        reviewWritten.publishAfterCommit();

    }

    public static ReviewRepository repository(){
        ReviewRepository reviewRepository = CustomerApplication.applicationContext.getBean(ReviewRepository.class);
        return reviewRepository;
    }






}

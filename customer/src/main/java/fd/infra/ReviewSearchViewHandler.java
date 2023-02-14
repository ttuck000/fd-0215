package fd.infra;

import fd.domain.*;
import fd.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewSearchViewHandler {

    @Autowired
    private ReviewSearchRepository reviewSearchRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReviewWritten_then_CREATE_1 (@Payload ReviewWritten reviewWritten) {
        try {

            if (!reviewWritten.validate()) return;

            // view 객체 생성
            ReviewSearch reviewSearch = new ReviewSearch();
            // view 객체에 이벤트의 Value 를 set 함
            reviewSearch.setReviewId(String.valueOf(reviewWritten.getId()));
            // view 레파지 토리에 save
            reviewSearchRepository.save(reviewSearch);

        }catch (Exception e){
            e.printStackTrace();
        }
    }




}


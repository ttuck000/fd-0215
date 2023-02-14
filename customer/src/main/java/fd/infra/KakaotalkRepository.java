package fd.infra;

import fd.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="kakaotalks", path="kakaotalks")
public interface KakaotalkRepository extends PagingAndSortingRepository<Kakaotalk, Long> {

    List<Kakaotalk> findByPhoneNumber(String phoneNumber);
List<Kakaotalk> findByUserId(String userId);


    
}

package fd.infra;

import fd.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderSearches", path="orderSearches")
public interface OrderSearchRepository extends PagingAndSortingRepository<OrderSearch, Long> {

    

    
}

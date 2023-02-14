package fd.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "customer", url = "${api.url.customer}")
public interface ReviewService {
    @RequestMapping(method= RequestMethod.GET, path="/reviews")
    public void writereview(@RequestBody Review review);
}

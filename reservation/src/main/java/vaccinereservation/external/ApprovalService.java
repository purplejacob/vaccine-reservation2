package vaccinereservation.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="approval", url="http://approval:8080")
public interface ApprovalService {
    @RequestMapping(method= RequestMethod.GET, path="/approvals")
    public void requestapproval(@RequestBody Approval approval);

}


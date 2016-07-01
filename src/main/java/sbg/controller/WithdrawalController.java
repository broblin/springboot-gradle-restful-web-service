package sbg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sbg.withdrawal.WithdrawalByLogisticianRequest;
import sbg.withdrawal.WithdrawalByLogisticianResponse;

import javax.validation.Valid;

/**
 * mocke le service de retractation appelé par ariane
 * Created by benoit on 01/07/16.
 */
@Controller
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @RequestMapping(value = "/withdrawByLogistician", method = RequestMethod.POST)
    public WithdrawalByLogisticianResponse withdrawByLogistician(@Valid @RequestBody WithdrawalByLogisticianRequest withdrawalByLogisticianRequest){
        WithdrawalByLogisticianResponse response =new  WithdrawalByLogisticianResponse();
        response.setCaseId("test mocké");
        return response;
    }
}

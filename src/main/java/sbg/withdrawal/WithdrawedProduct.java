package sbg.withdrawal;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by benoit on 01/07/16.
 */
public class WithdrawedProduct {

    @NotNull
    private String productReference;


    @NotBlank
    private String assemblySeriesNr;

    @NotNull
    private EWithdrawalPostAction postAction;

    private EWithdrawalStatus status;

    private String returnOrderErpId;

    Boolean isReturnSucessful;

    private String expedOrderErpId;

    private Boolean isExpedSucessful;

    private String rejectReason;

    public String getProductReference() {
        return productReference;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public String getAssemblySeriesNr() {
        return assemblySeriesNr;
    }

    public void setAssemblySeriesNr(String assemblySeriesNr) {
        this.assemblySeriesNr = assemblySeriesNr;
    }

    public EWithdrawalPostAction getPostAction() {
        return postAction;
    }

    public void setPostAction(EWithdrawalPostAction postAction) {
        this.postAction = postAction;
    }

    public EWithdrawalStatus getStatus() {
        return status;
    }

    public void setStatus(EWithdrawalStatus status) {
        this.status = status;
    }

    public String getReturnOrderErpId() {
        return returnOrderErpId;
    }

    public void setReturnOrderErpId(String returnOrderErpId) {
        this.returnOrderErpId = returnOrderErpId;
    }

    public Boolean getIsReturnSucessful() {
        return isReturnSucessful;
    }

    public void setIsReturnSucessful(Boolean isReturnSucessful) {
        this.isReturnSucessful = isReturnSucessful;
    }

    public String getExpedOrderErpId() {
        return expedOrderErpId;
    }

    public void setExpedOrderErpId(String expedOrderErpId) {
        this.expedOrderErpId = expedOrderErpId;
    }

    public Boolean getIsExpedSucessful() {
        return isExpedSucessful;
    }

    public void setIsExpedSucessful(Boolean isExpedSucessful) {
        this.isExpedSucessful = isExpedSucessful;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}

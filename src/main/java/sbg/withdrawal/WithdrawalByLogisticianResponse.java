package sbg.withdrawal;

/**
 * Created by benoit on 01/07/16.
 */
public class WithdrawalByLogisticianResponse {

    private String orderId;

    private String caseId;

    /**
     * Raison du rejet le cas échéant
     */
    private String rejectReason;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}

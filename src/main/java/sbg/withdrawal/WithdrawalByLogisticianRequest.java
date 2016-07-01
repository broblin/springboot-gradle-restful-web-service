package sbg.withdrawal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by benoit on 01/07/16.
 */
public class WithdrawalByLogisticianRequest {

    @NotNull
    private String orderId;

    @NotNull
    @JsonSerialize(using = IsoLocalDateTimeSerializer.class)
    private LocalDateTime returnDate;

    @NotNull
    @NotEmpty
    @Valid
    private List<WithdrawedProduct> products;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public List<WithdrawedProduct> getProducts() {
        return products;
    }

    public void setProducts(List<WithdrawedProduct> products) {
        this.products = products;
    }

}

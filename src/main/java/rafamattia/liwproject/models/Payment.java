package rafamattia.liwproject.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Payment {
    protected int paymentId;
    protected int wageId;
    protected Timestamp issueDate;
    protected float value;

    public Payment(){
        this.paymentId = 0;
        this.wageId = 0;
        this.issueDate = null;
        this.value = 0f;
    }
    public Payment(int wageId, Timestamp issueDate) {
        this.paymentId = 0;
        this.wageId = wageId;
        this.issueDate = issueDate;
        this.value = 0;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getWageId() {
        return wageId;
    }

    public void setWageId(int wageId) {
        this.wageId = wageId;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

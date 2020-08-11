package com.dulcepan.entity;

import com.dulcepan.entity.base.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@Entity
@Table(name = "payment_debt")
public class PaymentDebt extends AbstractEntity<Integer>{

    private Integer paymentDebtId;
    private Document document;
    private Client client;
    private TypePayment typePayment;
    private Date datePayment;
    private Integer amountPayment;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "payment_debt_id", unique = true, nullable = false)
    public Integer getPaymentDebtId() {
        return paymentDebtId;
    }

    @ManyToOne()
    @JsonManagedReference("payment_debt")
    @JoinColumn(name = "document_id", nullable = false)
    public Document getDocument() {
        return document;
    }

    @ManyToOne()
    @JsonManagedReference("payment_debt")
    @JoinColumn(name = "rut")
    public Client getClient() {
        return client;
    }

    @ManyToOne()
    @JsonManagedReference("payment_debt")
    @JoinColumn(name = "type_payment")
    public TypePayment getTypePayment() {
        return typePayment;
    }

    @Column(name = "date_payment")
    public Date getDatePayment() {
        return datePayment;
    }

    @Column(name = "amount_payment")
    public Integer getAmountPayment() {
        return amountPayment;
    }

    @Transient
    @Override
    public Integer getEntityId() {
        return getPaymentDebtId();
    }
}

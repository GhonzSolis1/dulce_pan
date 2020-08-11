package com.dulcepan.entity;

import com.dulcepan.entity.base.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Entity
@ToString
@Table(name = "type_payment")
public class TypePayment extends AbstractEntity<Integer> {

    private Integer typePaymentId;
    private String description;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "payment_id", unique = true, nullable = false)
    public Integer getTypePaymentId() {
        return typePaymentId;
    }

    @Column(name = "description")
    public String getDescription(){
        return description;
    }

    @Transient
    @Override
    public Integer getEntityId() {
        return getTypePaymentId();
    }
}
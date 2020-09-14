package com.dulcepan.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Entity
@ToString
@Table(name = "type_payment")
public class TypePayment {

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

}

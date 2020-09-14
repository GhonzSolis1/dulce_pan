package com.dulcepan.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@ToString
@Entity
@Table(name = "type_product")
public class TypeProduct  {

    private Integer typeProductId;
    private String descriptionTypeProduct;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_type_id", unique = true, nullable = false)
    public Integer getTypeProductId() {
        return typeProductId;
    }

    @Column(name = "description")
    public String getDescriptionTypeProduct() {
        return descriptionTypeProduct;
    }


}
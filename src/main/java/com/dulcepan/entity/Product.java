package com.dulcepan.entity;

import com.dulcepan.entity.base.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Builder
@Entity
@Table(name = "product")
public class Product extends AbstractEntity<Integer> {

    private Integer productId;
    private String nameProduct;
    private String descriptionProduct;
    private Integer priceReference;
    private TypeProduct typeProduct;
   // private List<Recipe> recipes;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
    public Integer getProductId() {
        return productId;
    }

    @Column(name = "name_product")
    public String getNameProduct() {
        return nameProduct;
    }

    @Column(name = "description_product")
    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    @Column(name = "price_reference")
    public Integer getPriceReference() {
        return priceReference;
    }

    @ManyToOne()
    @JsonManagedReference("type_product")
    @JoinColumn(name = "type_product", nullable = false)
    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

  /*  @OneToMany(mappedBy = "product",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JsonManagedReference("recipe_product")
    public List<Recipe> getRecipes() {
        return recipes;
    }*/

    @Transient
    @Override
    public Integer getEntityId() {
        return getProductId();
    }

}


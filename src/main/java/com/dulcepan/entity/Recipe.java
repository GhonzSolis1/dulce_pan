package com.dulcepan.entity;

import com.dulcepan.entity.base.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@ToString
@Entity
@Table(name = "recipe")
public class Recipe extends AbstractEntity<Integer> {

    private Integer recipeId;
    private RowMaterial rowMaterial;
    private Integer quantityPerProduct;
    private Product product;
    private Measure measure;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "recipe_id", unique = true, nullable = false)
    public Integer getRecipeId() {
        return recipeId;
    }

    @ManyToOne()
    @JsonManagedReference("recipe")
    @JoinColumn(name = "raw_material_id", nullable = false)
    public RowMaterial getRowMaterial() {
        return rowMaterial;
    }

    @Column(name = "quantity_per_product")
    public Integer getQuantityPerProduct() {
        return quantityPerProduct;
    }

    @ManyToOne()
    @JsonManagedReference("recipe_product")
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    @ManyToOne()
    @JsonManagedReference("recipe")
    @JoinColumn(name = "measure_id", nullable = false)
    public Measure getMeasure() {
        return measure;
    }

    @Transient
    @Override
    public Integer getEntityId() {
        return getRecipeId();
    }
}

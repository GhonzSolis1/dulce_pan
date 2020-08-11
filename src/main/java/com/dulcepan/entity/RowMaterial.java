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
@Table(name = "raw_material")
public class RowMaterial extends AbstractEntity<Integer> {

    public static final int UNDEFINED = 0;
    private Integer rowMaterialId;
    private String name;
    private String description;
    private Integer quantity;
    private Measure measure;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "raw_material_id", unique = true, nullable = false)
    public Integer getRowMaterialId() {
        return rowMaterialId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
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
        return getRowMaterialId();
    }
}

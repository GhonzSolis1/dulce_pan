package com.dulcepan.entity;


import com.dulcepan.entity.base.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@ToString
@Entity
@Table(name = "measure")
public class Measure extends AbstractEntity<Integer> {
    public static final int UNDEFINED = 3;
    private Integer measureId;
    private String description;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "measure_id", unique = true, nullable = false)
    public Integer getMeasureId() {
        return measureId;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Transient
    @Override
    public Integer getEntityId() {
        return getMeasureId();
    }
}
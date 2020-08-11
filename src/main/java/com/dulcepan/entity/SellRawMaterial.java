package com.dulcepan.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sell_raw_material")
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SellRawMaterial {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "sell_raw_material_id", unique = true, nullable = false)
    private Integer sellRawMaterialId;
    @ManyToOne()
    @JoinColumn(name = "provider_id" )
    private Provider provider;
    @ManyToOne()
    @JoinColumn(name = "raw_material_id")
    private RowMaterial rowMaterial;
    @Column(name = "price_detail")
    private Integer priceDetail;
    @Column(name = "price_total")
    private Integer priceTotal;
    private Date date;
    private Integer quantity;
}

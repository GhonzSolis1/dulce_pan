package com.dulcepan.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Builder
@Entity
@Table(name = "product_daily")
public class ProductDaily  {


    private Integer productDailyId;
    private Product product;
    private Integer stockDaily;
    private Integer stockDailyHis;
    private Date dateDaily;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_daily_id", unique = true, nullable = false)
    public Integer getProductDailyId() {
        return productDailyId;
    }

    @ManyToOne()
    @JsonManagedReference("product")
    @JoinColumn(name = "product_id", nullable = false)
    public Product getProduct() {
        return product;
    }

    @Column(name = "stock_daily")
    public Integer getStockDaily() {
        return stockDaily;
    }

    @Column(name = "date_daily")
    public Date getDateDaily() {
        return dateDaily;
    }

    @Column(name = "stock_daily_his")
    public Integer getStockDailyHis() {
        return stockDailyHis;
    }

}

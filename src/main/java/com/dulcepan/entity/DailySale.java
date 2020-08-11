package com.dulcepan.entity;

import com.dulcepan.entity.base.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "daily_sale")
public class DailySale  extends AbstractEntity<Integer> {

    private Integer dailySaleId;
    private ProductDaily productDaily;
    private Client client;
    private Integer priceReal;
    private Integer priceTotal;
    private Integer stock;
    private Document document;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "sale_id", unique = true, nullable = false)
    public Integer getDailySaleId() {
        return dailySaleId;
    }

    @ManyToOne()
    @JsonManagedReference("dailySale")
    @JoinColumn(name = "product_daily_id", nullable = false)
    public ProductDaily getProductDaily() {
        return productDaily;
    }

    @ManyToOne()
    @JsonManagedReference("daily_sale")
    @JoinColumn(name = "rut", nullable = false)
    public Client getClient() {
        return client;
    }

    @ManyToOne()
   // @JsonManagedReference("daily_sale")
    @JoinColumn(name = "document_id", nullable = false)
    public Document getDocument() {
        return document;
    }

    @Column(name = "price_real")
    public Integer getPriceReal() {
        return priceReal;
    }

    @Column(name = "price_total")
    public Integer getPriceTotal() {
        return priceTotal;
    }

    @Column(name = "stock")
    public Integer getStock() {
        return stock;
    }

    @Transient
    @Override
    public Integer getEntityId() {
        return getDailySaleId();
    }
}

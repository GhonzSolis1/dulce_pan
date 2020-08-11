package com.dulcepan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dulcepan.entity.base.AbstractEntity;
import lombok.*;

@Entity
@Table(name = "client")
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @Column(name = "rut", unique = true, nullable = false)
    private String rut;
    @Column(name = "name_client")
    private String nameClient;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "commune")
    private String commune;
    @Column(name = "name_market")
    private String nameMarket;
}

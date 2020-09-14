package com.dulcepan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name = "client")
@Data
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

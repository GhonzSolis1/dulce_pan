package com.dulcepan.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "vendor_id", unique = true, nullable = false)
    private Integer vendorId;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "commune")
    private String commune;
    
}

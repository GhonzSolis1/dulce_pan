package com.dulcepan.entity;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "provider_id", unique = true, nullable = false)
    private Integer providerId;
    @Column(name = "name")
    private String name;
    private String description;
    private String address;
}

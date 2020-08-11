package com.dulcepan.entity.security;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Role {

    @Id
    @Column(name = "role_id")
   // @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    //@GenericGenerator(name="native",strategy="native")
    private Long id;

    @Column
    private String role;

}

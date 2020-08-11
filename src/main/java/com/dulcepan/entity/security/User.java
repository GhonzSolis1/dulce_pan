package com.dulcepan.entity.security;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1671417246199538663L;

    @Id
    @Column
    private Long userId;

    @Column
    @NotBlank
    @Size(min=5,max=8,message="No se cumple las reglas del tamano")
    private String firstName;
    @Column
    @NotBlank
    private String lastName;
    @Column
    @NotBlank
    private String email;
    @Column
    @NotBlank
    private String username;
    @Column
    @NotBlank
    private String password;

    @Transient
    private String confirmPassword;

    @Size(min=1)
    @ManyToMany(    fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<com.dulcepan.entity.security.Role> roles;
}
package com.dulcepan.dto;

import lombok.*;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private String rut;
    private String nameClient;
    private String phone;
    private String address;
    private String commune;
    private String nameMarket;

}

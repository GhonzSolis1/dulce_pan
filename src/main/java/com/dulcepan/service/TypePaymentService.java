package com.dulcepan.service;

import com.dulcepan.entity.TypePayment;

import java.util.List;

public interface TypePaymentService {

    List<TypePayment> findAll();

    TypePayment findByDescription(String description);

}

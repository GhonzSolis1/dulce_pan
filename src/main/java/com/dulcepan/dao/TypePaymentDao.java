package com.dulcepan.dao;

import com.dulcepan.entity.TypePayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypePaymentDao extends JpaRepository<TypePayment,Integer> {

    List<TypePayment> findByDescription(String description);
}

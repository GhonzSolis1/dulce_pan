package com.dulcepan.service.impl;

import com.dulcepan.entity.TypePayment;
import com.dulcepan.dao.TypePaymentDao;
import com.dulcepan.service.TypePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePaymentServiceImpl implements TypePaymentService {

    private TypePaymentDao typePaymentDao;

    @Autowired
    public TypePaymentServiceImpl(TypePaymentDao typePaymentDao) {
        this.typePaymentDao = typePaymentDao;
    }

    @Override
    public List<TypePayment> findAll() {
        return typePaymentDao.findAll();
    }

    @Override
    public TypePayment findByDescription(String description) {
        return typePaymentDao.findByDescription(description).get(0);
    }
}

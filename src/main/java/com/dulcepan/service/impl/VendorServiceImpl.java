package com.dulcepan.service.impl;

import com.dulcepan.entity.Vendor;
import com.dulcepan.dao.VendorDao;
import com.dulcepan.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorDao vendorDao;

    @Autowired
    public VendorServiceImpl(VendorDao vendorDao) {
        this.vendorDao = vendorDao;
    }

    @Override
    public List<Vendor> findAll() {
        return vendorDao.findAll();
    }
}

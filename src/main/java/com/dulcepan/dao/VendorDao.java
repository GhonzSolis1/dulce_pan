package com.dulcepan.dao;

import com.dulcepan.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorDao extends JpaRepository<Vendor, Integer> {
}

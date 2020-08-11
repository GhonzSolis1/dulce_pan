package com.dulcepan.dao;

import com.dulcepan.entity.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureDao extends JpaRepository<Measure, Integer> {
}

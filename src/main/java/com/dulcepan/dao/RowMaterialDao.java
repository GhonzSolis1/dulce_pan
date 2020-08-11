package com.dulcepan.dao;

import com.dulcepan.entity.Measure;
import com.dulcepan.entity.RowMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RowMaterialDao extends JpaRepository<RowMaterial,Integer> {


    RowMaterial findByRowMaterialId(Integer idRowMaterial);

    List<RowMaterial> findByMeasureContaining(Measure measure);


    List<RowMaterial> findByNameContaining(String name);

    List<RowMaterial> findByDescriptionContaining(String description);


}

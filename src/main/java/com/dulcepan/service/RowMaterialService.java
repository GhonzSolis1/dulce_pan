package com.dulcepan.service;

import com.dulcepan.entity.Measure;
import com.dulcepan.entity.RowMaterial;

import java.util.List;

public interface RowMaterialService {


    List<RowMaterial> findAll();

    List<RowMaterial> findByNameContaining(String name);

    List<RowMaterial> findByDescriptionContaining(String description);

    List<RowMaterial> findByMeasureContaining(Measure measure);

    Boolean createRowMaterial(RowMaterial rowMaterial);

    RowMaterial findByIdRowMaterial(RowMaterial rowMaterial);


    RowMaterial updateRowMaterial(RowMaterial rowMaterial);
}

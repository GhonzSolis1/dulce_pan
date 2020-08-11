package com.dulcepan.service.manager;

import com.dulcepan.entity.Recipe;
import com.dulcepan.entity.RowMaterial;

import java.util.List;

public interface ManagerRowMaterialService {

    Integer subtractRowMaterial(Recipe recipe, Integer quantity);

    void additionRowMaterial(Recipe recipe, Integer quantity);

}

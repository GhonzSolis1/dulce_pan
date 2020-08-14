package com.dulcepan.dto;

import com.dulcepan.entity.TypeProduct;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer productId;
    private String nameProduct;
    private String descriptionProduct;
    private Integer priceReference;
    private TypeProduct typeProduct;
}

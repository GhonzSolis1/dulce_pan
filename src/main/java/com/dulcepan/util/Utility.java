package com.dulcepan.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Utility {

    public static final Integer ROW_MATERIAL_SUBTRACT_OK= 1;
    public static final Integer ROW_MATERIAL_SUBTRACT_QUANTITY_MINOR= 2;
    public static String dateFormat(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat();
        formatter.applyPattern("dd-MM-yyyy");
        return formatter.format(date);
    }

}

package com.alten.utils;

import com.alten.entity.Product;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public final class UtilsHelper {
    private UtilsHelper(){}
    public static < T , X> X mergeValues(T source , X destination){
        Field[] declaredFields = source.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object value = ReflectionUtils.getField(field, source);
            if (value != null) {
                Field updatedProductField = ReflectionUtils.findField(Product.class, field.getName());
                if (updatedProductField != null) {
                    updatedProductField.setAccessible(true);
                    ReflectionUtils.setField(updatedProductField, destination, value);
                }
            }
        }
        return destination;
    }

}

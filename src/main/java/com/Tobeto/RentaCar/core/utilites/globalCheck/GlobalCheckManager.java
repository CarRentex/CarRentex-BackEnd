package com.Tobeto.RentaCar.core.utilites.globalCheck;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;

@Service
public class GlobalCheckManager implements GlobalCheckService{
    public <T>void updateEntity(T existingEntity, T updatedEntity) {
        for (java.lang.reflect.Field field : existingEntity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object updatedValue = field.get(updatedEntity);
                if (updatedValue != null && !Objects.equals(updatedValue, field.get(existingEntity))) {
                    field.set(existingEntity, updatedValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error while updating entity. Please try again.");
            }
        }
    }
}

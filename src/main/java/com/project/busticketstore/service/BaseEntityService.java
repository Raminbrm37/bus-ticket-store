package com.project.busticketstore.service;

import com.project.busticketstore.dto.BaseEntityDto;
import com.project.busticketstore.model.BaseEntity;

import java.util.List;

public interface BaseEntityService<T extends BaseEntity,E> {
    T save(T entity);
    T findById(E id);
    List<E> findAll();
    Boolean remove(E entity);
    Boolean removeById(T id);

}

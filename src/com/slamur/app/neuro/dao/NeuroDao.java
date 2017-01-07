package com.slamur.app.neuro.dao;

import com.slamur.app.neuro.model.NeuroEntity;

import java.util.List;

public interface NeuroDao<EntityType extends NeuroEntity> {

    EntityType getById(int id);
    List<EntityType> getAll();

    void create(EntityType entity);
    void update(EntityType entity);

    default void remove(int id) {
        EntityType entity = getById(id);
        remove(entity);
    }

    void remove(EntityType entity);
}

package com.slamur.app.neuro.service;

import com.slamur.app.neuro.model.NeuroEntity;

import java.util.List;

public interface NeuroService<EntityType extends NeuroEntity> {

    EntityType getById(int id);
    List<EntityType> getAll();

    void create(EntityType entity);
    void update(EntityType entity);

    void remove(int id);
    void remove(EntityType entity);
}

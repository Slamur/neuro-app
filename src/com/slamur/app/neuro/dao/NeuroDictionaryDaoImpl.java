package com.slamur.app.neuro.dao;

import com.slamur.app.neuro.model.NeuroDictionaryEntity;
import com.slamur.app.neuro.model.NeuroEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class NeuroDictionaryDaoImpl<EntityType extends NeuroDictionaryEntity>
        extends NeuroDaoImpl<EntityType>
        implements NeuroDictionaryDao<EntityType> {

    protected NeuroDictionaryDaoImpl(Class<EntityType> entityClass) {
        super(entityClass);
    }
}

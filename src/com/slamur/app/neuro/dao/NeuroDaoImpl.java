package com.slamur.app.neuro.dao;

import com.slamur.app.neuro.model.NeuroEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class NeuroDaoImpl<EntityType extends NeuroEntity> implements NeuroDao<EntityType> {

    protected abstract EntityManager getEntityManager();

    protected final Class<EntityType> entityClass;

    protected NeuroDaoImpl(Class<EntityType> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public EntityType getById(int id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<EntityType> getAll() {
        Query query = getEntityManager().createQuery(
                String.format("SELECT e FROM %s e ORDER BY e.id ASC", entityClass.getSimpleName())
        );
        return (List<EntityType>)query.getResultList();
    }

    @Override
    public void create(EntityType entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void update(EntityType entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void remove(EntityType entity) {
        getEntityManager().remove(entity);
    }
}

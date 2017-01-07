package com.slamur.app.neuro.service;

import com.slamur.app.neuro.dao.NeuroDao;
import com.slamur.app.neuro.model.NeuroEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class NeuroServiceImpl<
        EntityType extends NeuroEntity,
        EntityDaoType extends NeuroDao<EntityType>
        >
        implements NeuroService<EntityType> {

    protected abstract EntityDaoType getEntityDao();

    @Override
    public EntityType getById(int id) {
        return getEntityDao().getById(id);
    }

    @Override
    public List<EntityType> getAll() {
        return getEntityDao().getAll();
    }

    @Override
    public void create(EntityType entity) {
        getEntityDao().create(entity);
    }

    @Override
    public void update(EntityType entity) {
        getEntityDao().update(entity);
    }

    @Override
    public void remove(int id) {
        getEntityDao().remove(id);
    }

    @Override
    public void remove(EntityType entity) {
        getEntityDao().remove(entity);
    }
}

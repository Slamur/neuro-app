package com.slamur.lib.service.impl;

import com.slamur.lib.dao.DomainDao;
import com.slamur.lib.domain.DomainEntity;
import com.slamur.lib.service.DomainService;

import java.util.List;

public abstract class DomainServiceImpl<
        EntityType extends DomainEntity,
        EntityDaoType extends DomainDao<EntityType>
        >
        implements DomainService<EntityType> {

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

package com.slamur.lib.dao.jpa;

import com.slamur.lib.dao.DomainDao;
import com.slamur.lib.domain.DomainEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Transactional
public abstract class DomainDaoJPA<EntityType extends DomainEntity>
        implements DomainDao<EntityType> {

    protected abstract EntityManager getEntityManager();

    protected final Class<EntityType> entityClass;
    protected final String entityClassName;

    protected DomainDaoJPA(Class<EntityType> entityClass) {
        this.entityClass = entityClass;
        this.entityClassName = entityClass.getSimpleName();
    }

    @Override
    public EntityType getById(int id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<EntityType> getAll() {
        Query query = getEntityManager().createQuery(
                String.format("SELECT e FROM %s e ORDER BY e.id ASC", entityClassName)
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

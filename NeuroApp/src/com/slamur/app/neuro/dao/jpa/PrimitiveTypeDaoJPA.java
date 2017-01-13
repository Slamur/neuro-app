package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.PrimitiveTypeDao;
import com.slamur.app.neuro.domain.meta_type.PrimitiveTypeEntity;
import com.slamur.lib.dao.jpa.DomainDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PrimitiveTypeDaoJPA
        extends DomainDaoJPA<PrimitiveTypeEntity>
        implements PrimitiveTypeDao {

    public PrimitiveTypeDaoJPA() {
        super(PrimitiveTypeEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

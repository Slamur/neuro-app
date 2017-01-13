package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.ParameterTypeDao;
import com.slamur.app.neuro.domain.parameter_type.ParameterTypeEntity;
import com.slamur.lib.dao.jpa.DomainDictionaryDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ParameterTypeDaoJPA
        extends DomainDictionaryDaoJPA<ParameterTypeEntity>
        implements ParameterTypeDao {

    public ParameterTypeDaoJPA() {
        super(ParameterTypeEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

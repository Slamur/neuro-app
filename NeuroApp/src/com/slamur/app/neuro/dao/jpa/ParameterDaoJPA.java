package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.ParameterDao;
import com.slamur.app.neuro.domain.parameter_type.ParameterEntity;
import com.slamur.lib.dao.jpa.DomainDictionaryDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ParameterDaoJPA
        extends DomainDictionaryDaoJPA<ParameterEntity>
        implements ParameterDao {

    public ParameterDaoJPA() {
        super(ParameterEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

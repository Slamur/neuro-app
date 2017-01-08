package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.AlgorithmDao;
import com.slamur.app.neuro.domain.AlgorithmEntity;
import com.slamur.lib.dao.jpa.DomainDictionaryDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class AlgorithmDaoJPA
        extends DomainDictionaryDaoJPA<AlgorithmEntity>
        implements AlgorithmDao {

    public AlgorithmDaoJPA() {
        super(AlgorithmEntity.class);
    }

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

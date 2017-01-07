package com.slamur.app.neuro.dao;

import com.slamur.app.neuro.model.AlgorithmEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class AlgorithmDaoJPA
        extends NeuroDictionaryDaoImpl<AlgorithmEntity>
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

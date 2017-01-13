package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.QueryParameterDao;
import com.slamur.app.neuro.domain.query.QueryParameterEntity;
import com.slamur.lib.dao.jpa.DomainDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class QueryParameterDaoJPA
        extends DomainDaoJPA<QueryParameterEntity>
        implements QueryParameterDao {

    public QueryParameterDaoJPA() {
        super(QueryParameterEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

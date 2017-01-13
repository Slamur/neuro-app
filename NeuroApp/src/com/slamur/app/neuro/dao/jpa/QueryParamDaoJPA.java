package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.QueryParamDao;
import com.slamur.app.neuro.domain.query.QueryParamEntity;
import com.slamur.lib.dao.jpa.DomainDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class QueryParamDaoJPA
        extends DomainDaoJPA<QueryParamEntity>
        implements QueryParamDao {

    public QueryParamDaoJPA() {
        super(QueryParamEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

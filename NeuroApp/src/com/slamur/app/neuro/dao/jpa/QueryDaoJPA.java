package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.QueryDao;
import com.slamur.app.neuro.domain.query.QueryEntity;
import com.slamur.lib.dao.jpa.DomainDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class QueryDaoJPA
        extends DomainDaoJPA<QueryEntity>
        implements QueryDao {

    public QueryDaoJPA() {
        super(QueryEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

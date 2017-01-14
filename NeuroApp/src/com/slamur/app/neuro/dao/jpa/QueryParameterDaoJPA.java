package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.QueryParameterDao;
import com.slamur.app.neuro.domain.query.QueryParameterEntity;
import com.slamur.lib.dao.jpa.DomainDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    @Override
    public List<QueryParameterEntity> getAllByQueryId(Integer queryId) {
        Query query = getEntityManager().createQuery(
                String.format("SELECT e FROM %s e where e.queryId = %d ORDER BY e.id ASC", entityClassName, queryId)
        );
        return (List<QueryParameterEntity>)query.getResultList();
    }

    @Override
    public boolean hasAnyWithParameterTypeAndValue(Integer parameterTypeId, Integer dictionaryId) {
        Query query = getEntityManager().createQuery(
                String.format(
                        "SELECT e FROM %s e where e.parameter.typeId = %d and e.value = \"%s\"",
                        entityClassName,
                        parameterTypeId,
                        Integer.toString(dictionaryId))
        );

        return query.getResultList().size() > 0;
    }

    @Override
    public boolean hasAnyWithParameterId(Integer parameterId) {
        Query query = getEntityManager().createQuery(
                String.format(
                        "SELECT e FROM %s e where e.parameter.id = %d",
                        entityClassName,
                        parameterId)
        );

        return query.getResultList().size() > 0;
    }
}

package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.QueryParameterDao;
import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.app.neuro.domain.parameter.ParameterEntity;
import com.slamur.app.neuro.domain.query.QueryEntity;
import com.slamur.app.neuro.domain.query.QueryParameterEntity;
import com.slamur.app.neuro.service.QueryParameterService;
import com.slamur.lib.service.impl.DomainServiceImpl;

import java.util.List;

public class QueryParameterServiceImpl
        extends DomainServiceImpl<QueryParameterEntity, QueryParameterDao>
        implements QueryParameterService {

    private QueryParameterDao queryParameterDao;

    public void setQueryParameterDao(QueryParameterDao queryParameterDao) {
        this.queryParameterDao = queryParameterDao;
    }

    @Override
    protected QueryParameterDao getEntityDao() {
        return queryParameterDao;
    }

    @Override
    public List<QueryParameterEntity> getAllByQuery(QueryEntity query) {
        return queryParameterDao.getAllByQueryId(query.getId());
    }

    @Override
    public boolean hasAnyWithReferenceValue(DictionaryEntity dictionary) {
        return queryParameterDao.hasAnyWithParameterTypeAndValue(
                dictionary.getType().getId(), dictionary.getId()
        );
    }

    @Override
    public boolean hasAnyWithParameter(ParameterEntity parameter) {
        return queryParameterDao.hasAnyWithParameterId(parameter.getId());
    }
}

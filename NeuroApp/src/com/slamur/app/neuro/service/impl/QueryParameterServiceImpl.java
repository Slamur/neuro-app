package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.QueryParameterDao;
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
}

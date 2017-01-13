package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.QueryParamDao;
import com.slamur.app.neuro.domain.query.QueryParamEntity;
import com.slamur.app.neuro.service.QueryParamService;
import com.slamur.lib.service.impl.DomainServiceImpl;

public class QueryParamServiceImpl
        extends DomainServiceImpl<QueryParamEntity, QueryParamDao>
        implements QueryParamService {

    private QueryParamDao queryParamDao;

    public void setQueryParamDao(QueryParamDao queryParamDao) {
        this.queryParamDao = queryParamDao;
    }

    @Override
    protected QueryParamDao getEntityDao() {
        return queryParamDao;
    }
}

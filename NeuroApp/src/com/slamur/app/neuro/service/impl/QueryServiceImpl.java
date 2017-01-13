package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.QueryDao;
import com.slamur.app.neuro.domain.query.QueryEntity;
import com.slamur.app.neuro.service.QueryService;
import com.slamur.lib.service.impl.DomainServiceImpl;

public class QueryServiceImpl
        extends DomainServiceImpl<QueryEntity, QueryDao>
        implements QueryService {

    private QueryDao queryDao;

    public void setQueryDao(QueryDao queryDao) {
        this.queryDao = queryDao;
    }

    @Override
    protected QueryDao getEntityDao() {
        return queryDao;
    }
}

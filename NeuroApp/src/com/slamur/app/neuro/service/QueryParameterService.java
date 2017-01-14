package com.slamur.app.neuro.service;

import com.slamur.app.neuro.domain.query.QueryEntity;
import com.slamur.app.neuro.domain.query.QueryParameterEntity;
import com.slamur.lib.service.DomainService;

import java.util.List;

public interface QueryParameterService extends DomainService<QueryParameterEntity> {
    List<QueryParameterEntity> getAllByQuery(QueryEntity query);
}

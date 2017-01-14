package com.slamur.app.neuro.dao;

import com.slamur.app.neuro.domain.query.QueryParameterEntity;
import com.slamur.lib.dao.DomainDao;

import java.util.List;

public interface QueryParameterDao extends DomainDao<QueryParameterEntity> {

    List<QueryParameterEntity> getAllByQueryId(Integer queryId);

    boolean hasAnyWithParameterTypeAndValue(Integer parameterTypeId, Integer dictionaryId);

    boolean hasAnyWithParameterId(Integer parameterId);
}

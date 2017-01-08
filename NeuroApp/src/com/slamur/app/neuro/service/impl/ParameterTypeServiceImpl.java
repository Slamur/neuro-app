package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.ParameterTypeDao;
import com.slamur.app.neuro.domain.ParameterTypeEntity;
import com.slamur.app.neuro.service.ParameterTypeService;
import com.slamur.lib.service.impl.DomainDictionaryServiceImpl;

public class ParameterTypeServiceImpl
        extends DomainDictionaryServiceImpl<ParameterTypeEntity, ParameterTypeDao>
        implements ParameterTypeService {

    private ParameterTypeDao parameterTypeDao;

    public void setParameterTypeDao(ParameterTypeDao parameterTypeDao) {
        this.parameterTypeDao = parameterTypeDao;
    }

    @Override
    protected ParameterTypeDao getEntityDao() {
        return parameterTypeDao;
    }
}

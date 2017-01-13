package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.ParameterDao;
import com.slamur.app.neuro.domain.parameter.ParameterEntity;
import com.slamur.app.neuro.service.ParameterService;
import com.slamur.lib.service.impl.DomainDictionaryServiceImpl;

public class ParameterServiceImpl
        extends DomainDictionaryServiceImpl<ParameterEntity, ParameterDao>
        implements ParameterService {

    private ParameterDao parameterDao;

    public void setParameterDao(ParameterDao parameterDao) {
        this.parameterDao = parameterDao;
    }

    @Override
    protected ParameterDao getEntityDao() {
        return parameterDao;
    }
}

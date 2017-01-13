package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.PrimitiveTypeDao;
import com.slamur.app.neuro.domain.meta_type.PrimitiveTypeEntity;
import com.slamur.app.neuro.service.DictionaryTypeService;
import com.slamur.app.neuro.service.ParameterTypeService;
import com.slamur.lib.service.impl.DomainServiceImpl;

public class ParameterTypeServiceImpl
        extends DomainServiceImpl<PrimitiveTypeEntity, PrimitiveTypeDao>
        implements ParameterTypeService {

    private PrimitiveTypeDao primitiveTypeDao;

    public void setPrimitiveTypeDao(PrimitiveTypeDao primitiveTypeDao) {
        this.primitiveTypeDao = primitiveTypeDao;
    }

    @Override
    protected PrimitiveTypeDao getEntityDao() {
        return primitiveTypeDao;
    }
}

package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.PrimitiveTypeDao;
import com.slamur.app.neuro.domain.meta_type.PrimitiveTypeEntity;
import com.slamur.app.neuro.service.PrimitiveTypeService;
import com.slamur.lib.service.impl.DomainServiceImpl;

public class PrimitiveTypeServiceImpl
        extends DomainServiceImpl<PrimitiveTypeEntity, PrimitiveTypeDao>
        implements PrimitiveTypeService {

    private PrimitiveTypeDao primitiveTypeDao;

    public void setPrimitiveTypeDao(PrimitiveTypeDao primitiveTypeDao) {
        this.primitiveTypeDao = primitiveTypeDao;
    }

    @Override
    protected PrimitiveTypeDao getEntityDao() {
        return primitiveTypeDao;
    }
}

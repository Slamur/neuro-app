package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.DictionaryTypeDao;
import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.app.neuro.service.DictionaryTypeService;
import com.slamur.lib.service.impl.DomainServiceImpl;

public class DictionaryTypeServiceImpl
        extends DomainServiceImpl<DictionaryTypeEntity, DictionaryTypeDao>
        implements DictionaryTypeService {

    private DictionaryTypeDao dictionaryTypeDao;

    public void setDictionaryTypeDao(DictionaryTypeDao dictionaryTypeDao) {
        this.dictionaryTypeDao = dictionaryTypeDao;
    }

    @Override
    protected DictionaryTypeDao getEntityDao() {
        return dictionaryTypeDao;
    }
}

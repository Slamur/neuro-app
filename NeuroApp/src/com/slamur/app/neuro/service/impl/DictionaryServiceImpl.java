package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.DictionaryDao;
import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.app.neuro.service.DictionaryService;
import com.slamur.lib.service.impl.DomainDictionaryServiceImpl;

import java.util.List;

public class DictionaryServiceImpl
        extends DomainDictionaryServiceImpl<DictionaryEntity, DictionaryDao>
        implements DictionaryService {

    private DictionaryDao dictionaryDao;

    public void setDictionaryDao(DictionaryDao dictionaryDao) {
        this.dictionaryDao = dictionaryDao;
    }

    @Override
    protected DictionaryDao getEntityDao() {
        return dictionaryDao;
    }

    @Override
    public List<DictionaryEntity> getAllByType(Integer typeId) {
        return dictionaryDao.getAllByType(typeId);
    }
}

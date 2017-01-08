package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.AlgorithmDao;
import com.slamur.app.neuro.domain.AlgorithmEntity;
import com.slamur.app.neuro.service.AlgorithmService;
import com.slamur.lib.service.impl.DomainDictionaryServiceImpl;

public class AlgorithmServiceImpl
        extends DomainDictionaryServiceImpl<AlgorithmEntity, AlgorithmDao>
        implements AlgorithmService {

    private AlgorithmDao algorithmDao;

    public void setAlgorithmDao(AlgorithmDao algorithmDao) {
        this.algorithmDao = algorithmDao;
    }

    @Override
    protected AlgorithmDao getEntityDao() {
        return algorithmDao;
    }
}

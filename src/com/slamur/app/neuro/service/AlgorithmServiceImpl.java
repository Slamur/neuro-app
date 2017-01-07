package com.slamur.app.neuro.service;

import com.slamur.app.neuro.dao.AlgorithmDao;
import com.slamur.app.neuro.model.AlgorithmEntity;

public class AlgorithmServiceImpl extends NeuroDictionaryServiceImpl<AlgorithmEntity, AlgorithmDao> {

    private AlgorithmDao algorithmDao;

    public void setAlgorithmDao(AlgorithmDao algorithmDao) {
        this.algorithmDao = algorithmDao;
    }

    @Override
    protected AlgorithmDao getEntityDao() {
        return algorithmDao;
    }
}

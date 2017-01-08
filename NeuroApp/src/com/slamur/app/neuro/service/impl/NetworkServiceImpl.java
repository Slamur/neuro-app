package com.slamur.app.neuro.service.impl;

import com.slamur.app.neuro.dao.NetworkDao;
import com.slamur.app.neuro.domain.NetworkEntity;
import com.slamur.app.neuro.service.NetworkService;
import com.slamur.lib.service.impl.DomainDictionaryServiceImpl;

public class NetworkServiceImpl
        extends DomainDictionaryServiceImpl<NetworkEntity, NetworkDao>
        implements NetworkService {

    private NetworkDao networkDao;

    public void setNetworkDao(NetworkDao networkDao) {
        this.networkDao = networkDao;
    }

    @Override
    protected NetworkDao getEntityDao() {
        return networkDao;
    }
}

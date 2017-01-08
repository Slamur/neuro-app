package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.NetworkDao;
import com.slamur.app.neuro.domain.NetworkEntity;
import com.slamur.lib.dao.jpa.DomainDictionaryDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class NetworkDaoJPA
        extends DomainDictionaryDaoJPA<NetworkEntity>
        implements NetworkDao {

    public NetworkDaoJPA() {
        super(NetworkEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

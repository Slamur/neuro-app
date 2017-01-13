package com.slamur.app.neuro.dao.jpa;

import com.slamur.app.neuro.dao.DictionaryTypeDao;
import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.lib.dao.jpa.DomainDaoJPA;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DictionaryTypeDaoJPA
        extends DomainDaoJPA<DictionaryTypeEntity>
        implements DictionaryTypeDao {

    public DictionaryTypeDaoJPA() {
        super(DictionaryTypeEntity.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

package com.slamur.lib.dao.jpa;

import com.slamur.lib.dao.DomainDictionaryDao;
import com.slamur.lib.domain.DomainDictionaryEntity;

public abstract class DomainDictionaryDaoJPA<EntityType extends DomainDictionaryEntity>
        extends DomainDaoJPA<EntityType>
        implements DomainDictionaryDao<EntityType> {

    protected DomainDictionaryDaoJPA(Class<EntityType> entityClass) {
        super(entityClass);
    }
}

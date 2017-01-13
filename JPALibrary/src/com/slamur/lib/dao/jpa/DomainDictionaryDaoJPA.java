package com.slamur.lib.dao.jpa;

import com.slamur.lib.dao.DomainDictionaryDao;
import com.slamur.lib.domain.DomainDictionaryEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class DomainDictionaryDaoJPA<EntityType extends DomainDictionaryEntity>
        extends DomainNamedDaoJPA<EntityType>
        implements DomainDictionaryDao<EntityType> {

    protected DomainDictionaryDaoJPA(Class<EntityType> entityClass) {
        super(entityClass);
    }
}

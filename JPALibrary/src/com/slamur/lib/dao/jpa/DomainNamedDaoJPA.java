package com.slamur.lib.dao.jpa;

import com.slamur.lib.dao.DomainNamedDao;
import com.slamur.lib.domain.DomainNamedEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class DomainNamedDaoJPA<EntityType extends DomainNamedEntity>
        extends DomainDaoJPA<EntityType>
        implements DomainNamedDao<EntityType> {

    protected DomainNamedDaoJPA(Class<EntityType> entityClass) {
        super(entityClass);
    }
}

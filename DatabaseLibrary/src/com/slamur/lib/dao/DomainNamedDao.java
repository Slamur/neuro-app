package com.slamur.lib.dao;

import com.slamur.lib.domain.DomainNamedEntity;

public interface DomainNamedDao<EntityType extends DomainNamedEntity>
        extends DomainDao<EntityType> {
}

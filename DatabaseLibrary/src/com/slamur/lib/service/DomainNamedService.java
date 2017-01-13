package com.slamur.lib.service;

import com.slamur.lib.domain.DomainNamedEntity;

public interface DomainNamedService<EntityType extends DomainNamedEntity>
        extends DomainService<EntityType> {
}

package com.slamur.lib.service.impl;

import com.slamur.lib.dao.DomainNamedDao;
import com.slamur.lib.domain.DomainNamedEntity;
import com.slamur.lib.service.DomainNamedService;

public abstract class DomainNamedServiceImpl<
        EntityType extends DomainNamedEntity,
        EntityDaoType extends DomainNamedDao<EntityType>
        >
        extends DomainServiceImpl<EntityType, EntityDaoType>
        implements DomainNamedService<EntityType> {

}

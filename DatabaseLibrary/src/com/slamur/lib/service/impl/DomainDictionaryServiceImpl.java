package com.slamur.lib.service.impl;

import com.slamur.lib.dao.DomainDictionaryDao;
import com.slamur.lib.domain.DomainDictionaryEntity;
import com.slamur.lib.service.DomainDictionaryService;

public abstract class DomainDictionaryServiceImpl<
        EntityType extends DomainDictionaryEntity,
        EntityDaoType extends DomainDictionaryDao<EntityType>
        >
        extends DomainNamedServiceImpl<EntityType, EntityDaoType>
        implements DomainDictionaryService<EntityType> {

}

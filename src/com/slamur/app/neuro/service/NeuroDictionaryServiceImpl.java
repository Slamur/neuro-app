package com.slamur.app.neuro.service;

import com.slamur.app.neuro.dao.NeuroDictionaryDao;
import com.slamur.app.neuro.model.NeuroDictionaryEntity;

public abstract class NeuroDictionaryServiceImpl<
        EntityType extends NeuroDictionaryEntity,
        EntityDaoType extends NeuroDictionaryDao<EntityType>
        >
        extends NeuroServiceImpl<EntityType, EntityDaoType>
        implements NeuroDictionaryService<EntityType> {

}

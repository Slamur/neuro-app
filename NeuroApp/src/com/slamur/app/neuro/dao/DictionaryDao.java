package com.slamur.app.neuro.dao;

import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.lib.dao.DomainDictionaryDao;

import java.util.List;

public interface DictionaryDao extends DomainDictionaryDao<DictionaryEntity> {

    List<DictionaryEntity> getAllByType(Integer typeId);
}

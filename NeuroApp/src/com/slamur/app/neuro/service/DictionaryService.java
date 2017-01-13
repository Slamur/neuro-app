package com.slamur.app.neuro.service;

import com.slamur.app.neuro.domain.dictionary.DictionaryEntity;
import com.slamur.lib.service.DomainDictionaryService;

import java.util.List;

public interface DictionaryService extends DomainDictionaryService<DictionaryEntity> {
    List<DictionaryEntity> getAllByType(Integer typeId);
}

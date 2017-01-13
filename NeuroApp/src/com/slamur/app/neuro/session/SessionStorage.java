package com.slamur.app.neuro.session;

import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.app.neuro.domain.meta_type.PrimitiveTypeEntity;
import com.slamur.lib.domain.DomainEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SessionStorage {

    boolean isEntityCreating();
    void setEntityCreating(boolean entityCreating);

    DomainEntity getEditingEntity();
    void setEditingEntity(DomainEntity entity);

    List<DictionaryTypeEntity> getDictionaryTypes();
    void setDictionaryTypes(List<DictionaryTypeEntity> dictionaryTypes);

    List<PrimitiveTypeEntity> getPrimitiveTypes();
    void setPrimitiveTypes(List<PrimitiveTypeEntity> dictionaryTypes);
}

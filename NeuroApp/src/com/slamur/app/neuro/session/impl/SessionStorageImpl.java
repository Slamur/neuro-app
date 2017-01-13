package com.slamur.app.neuro.session.impl;

import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.app.neuro.domain.meta_type.PrimitiveTypeEntity;
import com.slamur.app.neuro.session.SessionStorage;
import com.slamur.lib.domain.DomainEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionStorageImpl implements SessionStorage {

    private boolean isEntityCreating;
    private DomainEntity editingEntity;

    private List<DictionaryTypeEntity> dictionaryTypes;
    private List<PrimitiveTypeEntity> primitiveTypes;

    @Override
    public boolean isEntityCreating() {
        return isEntityCreating;
    }

    @Override
    public void setEntityCreating(boolean entityCreating) {
        isEntityCreating = entityCreating;
    }

    @Override
    public DomainEntity getEditingEntity() {
        return editingEntity;
    }

    @Override
    public void setEditingEntity(DomainEntity editingEntity) {
        this.editingEntity = editingEntity;
    }

    @Override
    public List<DictionaryTypeEntity> getDictionaryTypes() {
        return dictionaryTypes;
    }

    @Override
    public void setDictionaryTypes(List<DictionaryTypeEntity> dictionaryTypes) {
        this.dictionaryTypes = dictionaryTypes;
    }

    @Override
    public List<PrimitiveTypeEntity> getPrimitiveTypes() {
        return primitiveTypes;
    }

    @Override
    public void setPrimitiveTypes(List<PrimitiveTypeEntity> primitiveTypes) {
        this.primitiveTypes = primitiveTypes;
    }
}

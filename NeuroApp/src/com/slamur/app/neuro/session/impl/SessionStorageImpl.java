package com.slamur.app.neuro.session.impl;

import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.app.neuro.domain.meta_type.PrimitiveTypeEntity;
import com.slamur.app.neuro.session.SessionStorage;
import com.slamur.lib.domain.DomainEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SessionStorageImpl implements SessionStorage {

    private Set<Class<?>> entityCreatingClasses;
    private Map<Class<?>, DomainEntity> editingEntityByClasses;

    private List<DictionaryTypeEntity> dictionaryTypes;
    private List<PrimitiveTypeEntity> primitiveTypes;

    public SessionStorageImpl() {
        this.entityCreatingClasses = new HashSet<>();
        this.editingEntityByClasses = new HashMap<>();
    }

    @Override
    public boolean isEntityCreating(Class<?> entityClass) {
        return entityCreatingClasses.contains(entityClass);
    }

    @Override
    public void setEntityCreating(DomainEntity entity, boolean entityCreating) {
        if (entityCreating) entityCreatingClasses.add(entity.getClass());
        else entityCreatingClasses.remove(entity.getClass());
    }

    @Override
    public DomainEntity getEditingEntity(Class<?> entityClass) {
        return editingEntityByClasses.get(entityClass);
    }

    @Override
    public void setEditingEntity(DomainEntity entity) {
        editingEntityByClasses.put(entity.getClass(), entity);
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

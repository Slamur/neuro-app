package com.slamur.lib.domain.impl;

import com.slamur.lib.domain.DomainDictionaryEntity;

public abstract class DomainDictionaryEntityImpl
        extends DomainEntityImpl
        implements DomainDictionaryEntity {

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        DomainDictionaryEntityImpl other = (DomainDictionaryEntityImpl) obj;
        return getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = hash * ENTITY_HASH_BASE + getName().hashCode();
        return hash;
    }
}

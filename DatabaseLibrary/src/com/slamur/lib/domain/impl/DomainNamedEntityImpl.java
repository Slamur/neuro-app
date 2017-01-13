package com.slamur.lib.domain.impl;

import com.slamur.lib.domain.DomainNamedEntity;

public abstract class DomainNamedEntityImpl
        extends DomainEntityImpl
        implements DomainNamedEntity {

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        DomainNamedEntityImpl other = (DomainNamedEntityImpl) obj;
        return getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = hash * ENTITY_HASH_BASE + getName().hashCode();
        return hash;
    }
}

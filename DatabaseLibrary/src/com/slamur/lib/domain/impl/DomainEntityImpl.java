package com.slamur.lib.domain.impl;

import com.slamur.lib.domain.DomainEntity;

public abstract class DomainEntityImpl implements DomainEntity {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        DomainEntityImpl other = (DomainEntityImpl) obj;

        if (getId() == null) return other.getId() == null;
        return getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        Integer id = getId();
        hashCode = hashCode * ENTITY_HASH_BASE + (id == null ? 0 : id);

        return hashCode;
    }
}

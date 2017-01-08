package com.slamur.lib.domain.impl;

import com.slamur.lib.domain.DomainEntity;

public abstract class DomainEntityImpl implements DomainEntity {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        DomainEntityImpl other = (DomainEntityImpl) obj;

        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}

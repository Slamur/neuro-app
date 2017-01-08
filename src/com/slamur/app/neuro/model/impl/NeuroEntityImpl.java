package com.slamur.app.neuro.model.impl;

import com.slamur.app.neuro.model.NeuroEntity;

import javax.persistence.Column;

public abstract class NeuroEntityImpl implements NeuroEntity {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        NeuroEntityImpl other = (NeuroEntityImpl) obj;

        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}

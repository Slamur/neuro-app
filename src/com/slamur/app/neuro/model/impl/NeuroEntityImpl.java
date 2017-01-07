package com.slamur.app.neuro.model.impl;

import com.slamur.app.neuro.model.NeuroEntity;

import javax.persistence.Column;

public abstract class NeuroEntityImpl implements NeuroEntity {

    protected int id;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        NeuroEntityImpl other = (NeuroEntityImpl) obj;

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

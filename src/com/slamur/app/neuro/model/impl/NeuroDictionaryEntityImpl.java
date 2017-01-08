package com.slamur.app.neuro.model.impl;

import com.slamur.app.neuro.model.NeuroDictionaryEntity;

public abstract class NeuroDictionaryEntityImpl
        extends NeuroEntityImpl
        implements NeuroDictionaryEntity {

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        NeuroDictionaryEntityImpl other = (NeuroDictionaryEntityImpl) obj;
        return getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = hash * NEURO_HASH_BASE + getName().hashCode();
        return hash;
    }
}

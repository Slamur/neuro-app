package com.slamur.app.neuro.model.impl;

import com.slamur.app.neuro.model.NeuroDictionaryEntity;

public abstract class NeuroDictionaryEntityImpl
        extends NeuroEntityImpl
        implements NeuroDictionaryEntity {

    protected String name, description;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        NeuroDictionaryEntityImpl other = (NeuroDictionaryEntityImpl) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = hash * NEURO_HASH_BASE + name.hashCode();
        return hash;
    }
}

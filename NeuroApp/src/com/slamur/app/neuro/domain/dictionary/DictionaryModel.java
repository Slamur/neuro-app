package com.slamur.app.neuro.domain.dictionary;

import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;

public class DictionaryModel {

    private String name, description;
    private int typeId;

    public DictionaryModel() {

    }

    public DictionaryModel(DictionaryEntity dictionaryEntity) {
        this();

        this.name = dictionaryEntity.getName();
        this.description = dictionaryEntity.getDescription();

        DictionaryTypeEntity dictionaryType = dictionaryEntity.getType();
        this.typeId = dictionaryType == null ? 0 : dictionaryType.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}

package com.slamur.app.neuro.domain.parameter;

public class ParameterModel {

    private String name, description;
    private int typeId;

    public ParameterModel() {

    }

    public ParameterModel(ParameterEntity entity) {
        this();

        this.name = entity.getName();
        this.description = entity.getDescription();

        this.typeId = entity.getTypeId();
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

package com.slamur.app.neuro.domain.parameter_type;

public class ParameterModel {

    private String name, description;

    private boolean isPrimitive;
    private int typeId;

    public ParameterModel() {

    }

    public ParameterModel(ParameterEntity entity) {
        this();

        this.name = entity.getName();
        this.description = entity.getDescription();

        this.isPrimitive = entity.getTypeId() < 0;
        this.typeId = Math.abs(entity.getTypeId());
    }
}

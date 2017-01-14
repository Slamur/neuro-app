package com.slamur.app.neuro.domain.query;

public class QueryParameterModel {

    private int parameterId;
    private String value;

    public QueryParameterModel() {

    }

    public QueryParameterModel(QueryParameterEntity queryParameter) {
        this();

        this.parameterId = queryParameter.getParameter().getId();
        this.value = queryParameter.getValue();
    }

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public String getStringValue() {
        return value == null ? "" : value;
    }

    public void setStringValue(String value) {
        this.value = value;
    }

    public int getIdValue() {
        return (value == null || value.isEmpty())
                ? 1
                : Integer.parseInt(value);
    }

    public void setIdValue(int value) {
        this.value = Integer.toString(value);
    }

    public boolean getBooleanValue() {
        return !(value == null || value.isEmpty()) && Boolean.parseBoolean(value);
    }

    public void setBooleanValue(boolean value) {
        this.value = Boolean.toString(value);
    }
}

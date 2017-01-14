package com.slamur.app.neuro.domain.query;

import java.util.List;

public class QueryModel {

    private List<QueryParameterEntity> parameters;

    public QueryModel() {

    }

    public QueryModel(QueryEntity query) {
        this();
        this.parameters = query.getParameters();
    }

    public List<QueryParameterEntity> getParameters() {
        return parameters;
    }

    public void setParameters(List<QueryParameterEntity> parameters) {
        this.parameters = parameters;
    }
}

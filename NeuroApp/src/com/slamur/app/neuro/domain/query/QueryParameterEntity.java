package com.slamur.app.neuro.domain.query;

import com.slamur.lib.domain.impl.DomainEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "query_parameter", schema = "public", catalog = "neuroapp")
public class QueryParameterEntity extends DomainEntityImpl {

    private Integer id;
    private int queryId;
    private int paramTypeId;
    private String valueString;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "query_param_seq_id")
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "query_id")
    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    @Basic
    @Column(name = "param_type_id")
    public int getParamTypeId() {
        return paramTypeId;
    }

    public void setParamTypeId(int paramTypeId) {
        this.paramTypeId = paramTypeId;
    }

    @Basic
    @Column(name = "value_string")
    public String getValue() {
        return valueString;
    }

    public void setValue(String value) {
        this.valueString = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        QueryParameterEntity other = (QueryParameterEntity) obj;

        if (id != other.id) return false;
        if (queryId != other.queryId) return false;
        if (paramTypeId != other.paramTypeId) return false;
        if (valueString != null ? !valueString.equals(other.valueString) : other.valueString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = ENTITY_HASH_BASE * result + queryId;
        result = ENTITY_HASH_BASE * result + paramTypeId;
        result = ENTITY_HASH_BASE * result + (valueString != null ? valueString.hashCode() : 0);
        return result;
    }
}

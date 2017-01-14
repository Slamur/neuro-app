package com.slamur.app.neuro.domain.query;

import com.slamur.app.neuro.domain.parameter.ParameterEntity;
import com.slamur.lib.domain.impl.DomainEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "query_parameter", schema = "public", catalog = "neuroapp")
public class QueryParameterEntity extends DomainEntityImpl {

    public Integer id;
    public int queryId;
    public ParameterEntity parameter;
    public String valueString;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(targetEntity = ParameterEntity.class)
    public ParameterEntity getParameter() {
        return parameter;
    }

    public void setParameter(ParameterEntity parameter) {
        this.parameter = parameter;
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

        if (queryId != other.queryId) return false;
        if (!parameter.equals(other.parameter)) return false;
        if (valueString != null ? !valueString.equals(other.valueString) : other.valueString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = ENTITY_HASH_BASE * result + queryId;
        result = ENTITY_HASH_BASE * result + parameter.getId();
        result = ENTITY_HASH_BASE * result + (valueString != null ? valueString.hashCode() : 0);
        return result;
    }
}

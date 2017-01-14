package com.slamur.app.neuro.domain.query;

import com.slamur.lib.domain.impl.DomainEntityImpl;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "query", schema = "public", catalog = "neuroapp")
public class QueryEntity extends DomainEntityImpl {
    public static final int ADDED = 0, STARTED = ADDED + 1, FINISHED = STARTED + 1;

    public static final String[] QUERY_STATES = new String[] {
            "Add", "Start", "Finish"
    };

    public Integer id;

    public Timestamp timeAdded, timeStarted, timeFinished;

    public int stateType;
    public String resultString;

    private List<QueryParameterEntity> parameters;

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
    @Column(name = "time_added")
    public Timestamp getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Timestamp timeAdded) {
        this.timeAdded = timeAdded;
    }

    @Basic
    @Column(name = "time_started")
    public Timestamp getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Timestamp timeStarted) {
        this.timeStarted = timeStarted;
    }

    @Basic
    @Column(name = "time_finished")
    public Timestamp getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Timestamp timeFinished) {
        this.timeFinished = timeFinished;
    }

    @Basic
    @Column(name = "state_type")
    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }

    @Basic
    @Column(name = "result_string")
    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultFile) {
        this.resultString = resultFile;
    }

    @OneToMany(targetEntity = QueryParameterEntity.class)
    public List<QueryParameterEntity> getParameters() {
        return parameters;
    }

    public void setParameters(List<QueryParameterEntity> queryParameters) {
        this.parameters = queryParameters;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        QueryEntity other = (QueryEntity) obj;

        if (timeAdded != null ? !timeAdded.equals(other.timeAdded) : other.timeAdded != null) return false;
        if (timeStarted != null ? !timeStarted.equals(other.timeStarted) : other.timeStarted != null) return false;
        if (timeFinished != null ? !timeFinished.equals(other.timeFinished) : other.timeFinished != null) return false;
        if (stateType != other.stateType) return false;
        if (resultString != null ? !resultString.equals(other.resultString) : other.resultString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = id;
        hash = ENTITY_HASH_BASE * hash + (timeAdded != null ? timeAdded.hashCode() : 0);
        hash = ENTITY_HASH_BASE * hash + (timeStarted != null ? timeStarted.hashCode() : 0);
        hash = ENTITY_HASH_BASE * hash + (timeFinished != null ? timeFinished.hashCode() : 0);
        hash = ENTITY_HASH_BASE * hash + stateType;
        hash = ENTITY_HASH_BASE * hash + (resultString != null ? resultString.hashCode() : 0);
        return hash;
    }
}

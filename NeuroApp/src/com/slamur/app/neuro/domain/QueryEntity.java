package com.slamur.app.neuro.domain;

import com.slamur.lib.domain.impl.DomainEntityImpl;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "query", schema = "public", catalog = "neuroapp")
public class QueryEntity extends DomainEntityImpl {
    public static int ADDED = 0, STARTED = ADDED + 1, ENDED = STARTED + 1;

    private int id;

    private Date timeAdded, timeStarted, timeEnded;

    private int stateType;
    private String resultString;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "query_seq_id")
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time_added")
    public Date getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(Date timeAdded) {
        this.timeAdded = timeAdded;
    }

    @Basic
    @Column(name = "time_started")
    public Date getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Date timeStarted) {
        this.timeStarted = timeStarted;
    }

    @Basic
    @Column(name = "time_ended")
    public Date getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(Date timeEnded) {
        this.timeEnded = timeEnded;
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

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        QueryEntity other = (QueryEntity) obj;

        if (timeAdded != null ? !timeAdded.equals(other.timeAdded) : other.timeAdded != null) return false;
        if (timeStarted != null ? !timeStarted.equals(other.timeStarted) : other.timeStarted != null) return false;
        if (timeEnded != null ? !timeEnded.equals(other.timeEnded) : other.timeEnded != null) return false;
        if (stateType != other.stateType) return false;
        if (resultString != null ? !resultString.equals(other.resultString) : other.resultString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = id;
        hash = ENTITY_HASH_BASE * hash + (timeAdded != null ? timeAdded.hashCode() : 0);
        hash = ENTITY_HASH_BASE * hash + (timeStarted != null ? timeStarted.hashCode() : 0);
        hash = ENTITY_HASH_BASE * hash + (timeEnded != null ? timeEnded.hashCode() : 0);
        hash = ENTITY_HASH_BASE * hash + stateType;
        hash = ENTITY_HASH_BASE * hash + (resultString != null ? resultString.hashCode() : 0);
        return hash;
    }
}

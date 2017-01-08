package com.slamur.app.neuro.model;

import com.slamur.app.neuro.model.impl.NeuroDictionaryEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "parameter_type", schema = "public", catalog = "neuroapp")
public class ParameterTypeEntity extends NeuroDictionaryEntityImpl {

    private int id;
    private String name, description;

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

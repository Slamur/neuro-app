package com.slamur.app.neuro.domain;

import com.slamur.lib.domain.impl.DomainDictionaryEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "network", schema = "public", catalog = "neuroapp")
public class NetworkEntity extends DomainDictionaryEntityImpl {

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

package com.slamur.app.neuro.domain.parameter;

import com.slamur.lib.domain.impl.DomainDictionaryEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "parameter", schema = "public", catalog = "neuroapp")
public class ParameterEntity extends DomainDictionaryEntityImpl {

    public Integer id;
    public String name, description;
    public int typeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type_id")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}

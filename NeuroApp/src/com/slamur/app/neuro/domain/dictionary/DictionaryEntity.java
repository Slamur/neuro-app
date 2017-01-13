package com.slamur.app.neuro.domain.dictionary;

import com.slamur.app.neuro.domain.meta_type.DictionaryTypeEntity;
import com.slamur.lib.domain.impl.DomainDictionaryEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "dictionary", schema = "public", catalog = "neuroapp")
public class DictionaryEntity extends DomainDictionaryEntityImpl {

    public Integer id;
    public String name, description;
    public DictionaryTypeEntity type;
    public int typeId;

    @Id
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
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type_id")
    @OneToOne(targetEntity = DictionaryTypeEntity.class)
    public DictionaryTypeEntity getType() {
        return type;
    }

    public void setType(DictionaryTypeEntity type) {
        this.type = type;
    }

    @Transient
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}

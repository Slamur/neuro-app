package com.slamur.app.neuro.domain.meta_type;

import com.slamur.lib.domain.impl.DomainNamedEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "primitive_type", schema = "public", catalog = "neuroapp")
public class PrimitiveTypeEntity extends DomainNamedEntityImpl {

    public Integer id;
    public String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.slamur.app.neuro.model;

import com.slamur.app.neuro.model.impl.NeuroDictionaryEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "algorithm", schema = "public", catalog = "neuroapp")
public class AlgorithmEntity extends NeuroDictionaryEntityImpl {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "algorithm_seq_id")
    @Override
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
}

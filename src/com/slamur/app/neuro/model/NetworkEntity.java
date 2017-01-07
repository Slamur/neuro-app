package com.slamur.app.neuro.model;

import com.slamur.app.neuro.model.impl.NeuroDictionaryEntityImpl;

import javax.persistence.*;

@Entity
@Table(name = "network", schema = "public", catalog = "neuroapp")
public class NetworkEntity extends NeuroDictionaryEntityImpl {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "network_seq_id")
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

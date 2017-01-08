package com.slamur.lib.domain;

public interface DomainDictionaryEntity extends DomainEntity {

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);
}

package com.boardapp.boardapi.car.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;

@Table("engine")
public class Engine implements Persistable<String>{
    @Column("engine_name")
    private String engineName;

    @Column("engine_type")
    private String engineType;

    @Setter
    @Transient
    private boolean isNew = false;

    @Override
    @Nullable
    @JsonIgnore
    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public boolean isNew() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isNew'");
    }
}

package com.boardapp.boardapi.car.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table("engine")
public class Engine implements Persistable<String>{
    @Column("engine_id")
    @JsonBackReference
    private String engineId;

    @Id
    @Setter
    @Column("engine_name")
    private String engineName;

    @Column("engine_type")
    private String engineType;

    @Column("car_engine")
    @JsonManagedReference
    private Car TargetCar;

    @Setter
    @Transient
    @JsonIgnore
    private boolean isNew = false;

    @Override
    @Nullable
    @JsonIgnore
    public String getId() {
        return this.engineName;
    }
}

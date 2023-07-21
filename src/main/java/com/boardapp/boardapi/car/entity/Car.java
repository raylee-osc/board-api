package com.boardapp.boardapi.car.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;

@Setter
@Table("car")
public class Car {
    @Id
    @Column("car_id")
    private Long carId;

    @Column("car_name")
    private String carName;

    @Column("car_engine")
    private String carEngineName;

    @Column("engine_name")
    @JsonIgnore
    private Engine carEngine;
}

package com.boardapp.boardapi.car.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table("car")
public class Car {
    @Id
    @Column("car_id")
    private Long carId;

    @Column("car_name")
    private String carName;

    @Column("car_engine")
    @JsonBackReference
    private String carEngineName;

    @Column("engine_id")
    @JsonManagedReference
    private Engine carEngine;
}

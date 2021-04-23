package com.project.busticketstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bus")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bus extends BaseEntity<Long>{
    @Column(name = "bus_name",nullable = false,unique = true)
    private String name;
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;



}

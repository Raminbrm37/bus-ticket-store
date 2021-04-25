package com.project.busticketstore.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "travel")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Travel extends BaseEntity<Long> {
    @Enumerated(EnumType.STRING)
    private TravelStatus travelStatus;

    private Double price;

    private Boolean isActive;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;


    @Temporal(TemporalType.TIME)
    @Column(name = "time")
    private Date time;


    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private City origin;

    @ManyToMany
    @JoinTable(
            name = "travel_destination"
            ,joinColumns = @JoinColumn(name = "travel_id")
            ,inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private Set<City> destination;

}

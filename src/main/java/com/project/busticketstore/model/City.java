package com.project.busticketstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class City extends BaseEntity<Long> {
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "is_active")
    private Boolean isActive;

}

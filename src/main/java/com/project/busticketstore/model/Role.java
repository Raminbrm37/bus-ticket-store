package com.project.busticketstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<Long>implements Serializable {
    @Column(unique = true)
    private String name;

    @ElementCollection(targetClass = com.project.busticketstore.model.Authority.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Authority> authorities;

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}

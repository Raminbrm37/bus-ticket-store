package com.project.busticketstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chair")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Chair extends BaseEntity<Long> {
}
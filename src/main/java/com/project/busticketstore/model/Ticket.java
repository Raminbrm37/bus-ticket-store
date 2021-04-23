package com.project.busticketstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseEntity<Long> {
    @Column(nullable = false, name = "ticket_number", unique = true)
    private long ticketNumber;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    private Double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

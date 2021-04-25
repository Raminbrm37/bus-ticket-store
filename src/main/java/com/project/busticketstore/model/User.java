package com.project.busticketstore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public  class User extends BaseEntity<Long> {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Transient
    private String retypePassword;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "national_code", nullable = false, unique = true)
    private String nationalCode;
    @Column(name = "mobile_number", nullable = false, unique = true)
    private String mobileNumber;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "create_at",updatable = false)
    @CreationTimestamp
    private LocalDate createAt;
    @Column(name = "update_at")
    @CreationTimestamp
    private LocalDate updateAt;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @Enumerated(value = EnumType.STRING)
    private UserType userType;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}

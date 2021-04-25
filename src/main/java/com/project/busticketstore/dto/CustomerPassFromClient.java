package com.project.busticketstore.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;
@Setter
@Getter
public class CustomerPassFromClient {
    private String firstName;
    private String lastName;
        private String password;
//    private String retypePassword;
    private String username;
    private String email;
    private String nationalCode;
    private Date birthday;
    private LocalDate createAt;
    private LocalDate updateAt;
}

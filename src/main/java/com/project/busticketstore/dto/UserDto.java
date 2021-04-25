package com.project.busticketstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class UserDto  {
    private String firstName;
    private String lastName;
//    private String password;
//    private String retypePassword;
    private String username;
    private String email;
//    private String nationalCode;
//    private Date birthday;

}

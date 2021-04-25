package com.project.busticketstore.service;

import com.project.busticketstore.dto.BaseEntityDto;
import com.project.busticketstore.dto.UserDto;
import com.project.busticketstore.model.User;
import com.project.busticketstore.util.exception.UserAlreadyExistException;

public interface UserService extends BaseEntityService<User,Long> {
    UserDto createCustomer(User user)throws UserAlreadyExistException;
    Boolean checkIfUserExist(String username, String email, String nationalCode, String mobileNumber);
}

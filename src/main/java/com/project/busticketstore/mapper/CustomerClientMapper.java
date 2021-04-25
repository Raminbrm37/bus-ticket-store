package com.project.busticketstore.mapper;

import com.project.busticketstore.dto.CustomerPassFromClient;
import com.project.busticketstore.model.User;
import com.project.busticketstore.model.UserType;
import org.springframework.stereotype.Component;

@Component
public class CustomerClientMapper {
    public User convertUserDtoPassFromClientToUser(CustomerPassFromClient client){
        User user=new User();
        user.setFirstName(client.getFirstName());
        user.setLastName(client.getLastName());
        user.setPassword(client.getPassword());
        user.setUsername(client.getUsername());
        user.setNationalCode(client.getNationalCode());
        user.setEmail(client.getEmail());
        user.setMobileNumber(client.getEmail());
        user.setCreateAt(client.getCreateAt());
        user.setUpdateAt(client.getUpdateAt());
        user.setBirthDay(client.getBirthday());
        user.setIsActive(false);
        user.setUserType(UserType.CUSTOMER);
        return user;
    }
}

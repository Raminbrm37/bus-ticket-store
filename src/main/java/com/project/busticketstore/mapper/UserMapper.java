package com.project.busticketstore.mapper;

import com.project.busticketstore.dto.UserDto;
import com.project.busticketstore.model.Role;
import com.project.busticketstore.model.User;
import com.project.busticketstore.model.UserType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class UserMapper {

public UserDto convertUserToUserDto(User user){
    UserDto userDto=new UserDto();
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setEmail(user.getEmail());
    userDto.setUsername(user.getUsername());
//    userDto.setId();
    return userDto;
}
 public List<UserDto>  getAllUserDto(List<User> users){
    List<UserDto> userDtoList=new ArrayList<>();
    users.forEach(user -> userDtoList.add(convertUserToUserDto(user)));
    return userDtoList;
 }


//    public User convertUserDtoToUser(UserDto userDto) {
//        User user = new User();
//        user.setFirstName(user.getFirstName());
//        user.setLastName(user.getFirstName());
//        user.setUsername(user.getFirstName());
//        user.setEmail();
//        user.setNationalCode();
//        user.setBirthDay();
//        user.setUserType(UserType.CUSTOMER);
//    }
}

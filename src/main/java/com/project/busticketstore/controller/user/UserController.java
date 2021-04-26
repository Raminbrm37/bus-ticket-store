package com.project.busticketstore.controller.user;

import com.project.busticketstore.dto.UserDto;
import com.project.busticketstore.mapper.UserMapper;
import com.project.busticketstore.model.User;
import com.project.busticketstore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/view/{id}")
    public ResponseEntity<UserDto> getUserInformation(@PathVariable("id") Long id){
        User user = userService.findById(id);
        return  ResponseEntity.ok(userMapper.convertUserToUserDto(user));
    }

}

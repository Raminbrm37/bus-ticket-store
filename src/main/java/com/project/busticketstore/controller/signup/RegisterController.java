package com.project.busticketstore.controller.signup;

import com.project.busticketstore.dto.CustomerPassFromClient;
import com.project.busticketstore.mapper.CustomerClientMapper;
import com.project.busticketstore.mapper.UserMapper;
import com.project.busticketstore.model.User;
import com.project.busticketstore.service.impl.UserServiceImpl;
import com.project.busticketstore.util.exception.UserAlreadyExistException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value ="/register")
public class RegisterController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomerClientMapper customerClientMapper;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping(value ="/create-customer")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerPassFromClient customerPassFromClient)throws UserAlreadyExistException {
//        try {
//            User user = modelMapper.map(customerPassFromClient, User.class);
//            System.out.println("user :" + user.getEmail());
        return ResponseEntity.ok((userService.createCustomer(customerClientMapper.convertUserDtoPassFromClientToUser(customerPassFromClient))));


    }

//    @GetMapping("/user/{id:\\d+}")
//    public String gettest() {
//
//    }
}

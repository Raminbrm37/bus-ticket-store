package com.project.busticketstore.controller.user;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/register")
public class RegisterController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomerClientMapper customerClientMapper;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping(name = "/create-customer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerPassFromClient customerPassFromClient) throws UserAlreadyExistException {
        try {
            User user = modelMapper.map(customerPassFromClient, User.class);
            System.out.println("user :" + user.getEmail());
            return ResponseEntity.ok((userService.createCustomer(customerClientMapper.convertUserDtoPassFromClientToUser(customerPassFromClient))));
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }

    }

//    @GetMapping("/user/{id:\\d+}")
//    public String gettest() {
//
//    }
}

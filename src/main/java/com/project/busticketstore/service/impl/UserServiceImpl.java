package com.project.busticketstore.service.impl;

import com.project.busticketstore.dto.UserDto;
import com.project.busticketstore.mapper.UserMapper;
import com.project.busticketstore.model.User;
import com.project.busticketstore.model.UserType;
import com.project.busticketstore.repository.UserRepository;
import com.project.busticketstore.service.UserService;
import com.project.busticketstore.util.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createCustomer(User user) throws UserAlreadyExistException {
        if (this.checkIfUserExist(user.getUsername(),user.getEmail(),user.getNationalCode(),user.getMobileNumber())){
            throw new UserAlreadyExistException("user already exists");
        }
        user.setUserType(UserType.CUSTOMER);
        return userMapper.convertUserToUserDto(userRepository.save(user));
    }

    @Override
    public Boolean checkIfUserExist(String username, String email, String nationalCode, String mobileNumber) {
        return userRepository.findByUsernameOrEmailOrNationalCodeOrMobileNumber(username, email, nationalCode, mobileNumber)!=null;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<Long> findAll() {
        return null;
    }

    @Override
    public Boolean remove(Long entity) {
        return null;
    }

    @Override
    public Boolean removeById(User id) {
        return null;
    }
}

package com.example.schoolmanagerrest.facades;

import com.example.schoolmanagerrest.model.Params.user.AddUserParam;
import com.example.schoolmanagerrest.model.Params.user.UpdateUserParam;
import com.example.schoolmanagerrest.model.dto.UserDTO;
import com.example.schoolmanagerrest.model.entity.User;
import com.example.schoolmanagerrest.model.mappers.UserMapper;
import com.example.schoolmanagerrest.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional( propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class UserFacade {
    @Autowired
    private UserService userService;

    public List<UserDTO> getAllUsers() {
        return UserMapper.fromUserList(userService.getAllUsers());
    }

    public UserDTO getUserByID(long id) throws Exception {
        return UserMapper.fromUser(userService.getUserByID(id));
    }

    public UserDTO createUser(AddUserParam addUser) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.convertValue(addUser, User.class);
        return UserMapper.fromUser(userService.createUser(user));
    }

    public UserDTO updateUser(long id , UpdateUserParam newUser) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.convertValue(newUser, User.class);
        user.setId(id);
        return UserMapper.fromUser(userService.updateUser(user));
    }

    public void deleteUser(DeleteUserParam deleteUser) throws Exception {
        User user = userService.getUserByID(deleteUser.getId());
        userService.deleteUser(user);
    }
}

package com.example.schoolmanagerrest.controllers;

import com.example.schoolmanagerrest.exceptions.ResourceNotFoundException;
import com.example.schoolmanagerrest.facades.UserFacade;
import com.example.schoolmanagerrest.model.Params.user.AddUserParam;
import com.example.schoolmanagerrest.model.Params.user.UpdateUserParam;
import com.example.schoolmanagerrest.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userFacade.getAllUsers();
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable(value = "id") Long userId) throws Exception {
        return userFacade.getUserByID(userId);
    }

    @PostMapping("/users")
    public UserDTO createUser(@Valid @RequestBody AddUserParam adduser) {
        return userFacade.createUser(adduser);
    }

    /**
     * Update user response entity.
     *
     * @param userId the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody UpdateUserParam userDetails) throws Exception {
       return userFacade.updateUser(userId , userDetails);
    }

    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        DeleteUserParam param = new DeleteUserParam(userId);
        userFacade.deleteUser(param);
    }
}

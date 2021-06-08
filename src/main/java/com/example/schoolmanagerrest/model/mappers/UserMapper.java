package com.example.schoolmanagerrest.model.mappers;

import com.example.schoolmanagerrest.model.dto.UserDTO;
import com.example.schoolmanagerrest.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO fromUser(User user) {
        if (user == null)
            return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setCreatedBy(user.getCreatedBy());
        dto.setUpdatedBy(user.getUpdatedBy());
        return dto;
    }

    public static List<UserDTO> fromUserList(List<User> users) {
        return users.stream().map(UserMapper::fromUser).collect(Collectors.toList());
    }
}

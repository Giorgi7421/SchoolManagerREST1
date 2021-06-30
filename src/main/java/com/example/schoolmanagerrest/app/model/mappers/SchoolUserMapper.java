package com.example.schoolmanagerrest.app.model.mappers;

import com.example.schoolmanagerrest.app.model.dto.SchoolUserDTO;
import com.example.schoolmanagerrest.app.model.entity.SchoolUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolUserMapper {

    public static SchoolUserDTO fromSchoolUser(SchoolUser schoolUser) {
        if (schoolUser == null)
            return null;
        ObjectMapper objectMapper = new ObjectMapper();
        SchoolUserDTO dto = new SchoolUserDTO();
        dto.setId(schoolUser.getId());
        dto.setFirstName(schoolUser.getFirstName());
        dto.setLastName(schoolUser.getLastName());
        dto.setMobileNumber(schoolUser.getMobileNumber());
        dto.setUserName(schoolUser.getUserName());
        dto.setPassword(schoolUser.getPassword());
        return dto;
    }

    public static List<SchoolUserDTO> fromSchoolUsersList(List<SchoolUser> users) {
        return users.stream().map(SchoolUserMapper::fromSchoolUser).collect(Collectors.toList());
    }

}

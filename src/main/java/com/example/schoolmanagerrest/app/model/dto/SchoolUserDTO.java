package com.example.schoolmanagerrest.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolUserDTO {

    private long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;

}

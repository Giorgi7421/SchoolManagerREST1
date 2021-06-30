package com.example.schoolmanagerrest.app.model.Params.SchoolUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSchoolUserParam {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;

}

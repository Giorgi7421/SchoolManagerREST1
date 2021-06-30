package com.example.schoolmanagerrest.app.model.Params.SchoolUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSchoolUserParam {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;

}

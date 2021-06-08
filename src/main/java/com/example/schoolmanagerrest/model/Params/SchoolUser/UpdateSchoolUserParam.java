package com.example.schoolmanagerrest.model.Params.SchoolUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSchoolUserParam {

    private String firstName;
    private String lastName;
    private String mobileNumber;

}

package com.example.schoolmanagerrest.model.Params.SchoolUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSchoolUserParam {

    private String firstName;
    private String lastName;
    private String mobileNumber;

}

package com.example.schoolmanagerrest.model.Params.user;

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

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
}

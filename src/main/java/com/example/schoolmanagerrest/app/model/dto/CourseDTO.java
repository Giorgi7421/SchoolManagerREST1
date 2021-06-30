package com.example.schoolmanagerrest.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

}

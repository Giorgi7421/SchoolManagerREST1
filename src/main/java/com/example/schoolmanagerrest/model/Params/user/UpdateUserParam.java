package com.example.schoolmanagerrest.model.Params.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserParam {
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}

package com.example.schoolmanagerrest.model.Params.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserParam {

    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

}

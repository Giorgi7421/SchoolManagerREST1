package com.example.schoolmanagerrest.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="schoolusers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private long id;
    @Column(name="user_name" , unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private boolean isDeleted;
}

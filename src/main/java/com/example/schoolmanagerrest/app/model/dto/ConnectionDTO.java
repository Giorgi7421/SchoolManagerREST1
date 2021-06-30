package com.example.schoolmanagerrest.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionDTO {

    private long id;
    private long userId;
    private long courseId;

}

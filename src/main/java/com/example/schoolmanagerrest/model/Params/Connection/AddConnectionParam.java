package com.example.schoolmanagerrest.model.Params.Connection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddConnectionParam {

    private int userId;
    private int courseId;

}

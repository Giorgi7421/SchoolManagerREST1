package com.example.schoolmanagerrest.app.model.Params.Connection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateConnectionParam {

    private int userId;
    private int courseId;

}

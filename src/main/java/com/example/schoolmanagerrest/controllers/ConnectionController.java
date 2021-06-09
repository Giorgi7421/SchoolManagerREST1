package com.example.schoolmanagerrest.controllers;

import com.example.schoolmanagerrest.facades.ConnectionFacade;
import com.example.schoolmanagerrest.facades.CourseFacade;
import com.example.schoolmanagerrest.model.Params.Connection.AddConnectionParam;
import com.example.schoolmanagerrest.model.Params.Connection.UpdateConnectionParam;
import com.example.schoolmanagerrest.model.Params.Course.AddCourseParam;
import com.example.schoolmanagerrest.model.Params.Course.UpdateCourseParam;
import com.example.schoolmanagerrest.model.dto.ConnectionDTO;
import com.example.schoolmanagerrest.model.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ConnectionController {

    @Autowired
    private ConnectionFacade connectionFacade;

    @GetMapping("/Connection")
    public List<ConnectionDTO> getAllConnections() {
        return connectionFacade.getAllConnections();
    }

    @GetMapping("/Connection/{id}")
    public ConnectionDTO getConnectionById(@PathVariable(value = "id") int id) throws Exception {
        return connectionFacade.getConnectionByID(id);
    }

    @PostMapping("/Connection")
    public ConnectionDTO createConnection(@Valid @RequestBody AddConnectionParam addConnectionParam) {
        return connectionFacade.createConnection(addConnectionParam);
    }

    @PutMapping("/Connection/{id}")
    public ConnectionDTO updateConnection(@PathVariable(value = "id") int id, @Valid @RequestBody UpdateConnectionParam updateConnectionParam) throws Exception {
        return connectionFacade.updateConnection(id , updateConnectionParam);
    }

    @DeleteMapping("/Connection/{id}")
    public void deleteConnection(@PathVariable(value = "id") int id) throws Exception {
        connectionFacade.deleteConnection(id);
    }

}

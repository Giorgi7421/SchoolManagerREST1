package com.example.schoolmanagerrest.facades;

import com.example.schoolmanagerrest.model.Params.Connection.AddConnectionParam;
import com.example.schoolmanagerrest.model.Params.Connection.UpdateConnectionParam;
import com.example.schoolmanagerrest.model.Params.Course.AddCourseParam;
import com.example.schoolmanagerrest.model.Params.Course.UpdateCourseParam;
import com.example.schoolmanagerrest.model.dto.ConnectionDTO;
import com.example.schoolmanagerrest.model.dto.CourseDTO;
import com.example.schoolmanagerrest.model.entity.Connection;
import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.model.mappers.ConnectionMapper;
import com.example.schoolmanagerrest.model.mappers.CourseMapper;
import com.example.schoolmanagerrest.services.ConnectionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional( propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class ConnectionFacade {

    @Autowired
    private ConnectionService connectionService;

    public List<ConnectionDTO> getAllConnections(){
        return ConnectionMapper.fromConnectionList(connectionService.getAllConnections());
    }

    public ConnectionDTO getConnectionByID(int id) throws Exception {
        return ConnectionMapper.fromConnection(connectionService.getConnectionByID(id));
    }

    public ConnectionDTO createConnection(AddConnectionParam addConnectionParam) {
        ObjectMapper objectMapper = new ObjectMapper();
        Connection connection = objectMapper.convertValue(addConnectionParam, Connection.class);
        return ConnectionMapper.fromConnection(connectionService.createConnection(connection));
    }

    public ConnectionDTO updateConnection(int id , UpdateConnectionParam newConnection) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Connection connection = new Connection();

        connection.setCourseId(newConnection.getCourseId());
        connection.setUserId(newConnection.getUserId());
        connection.setDeleted(false);

        connection.setId(id);
        return ConnectionMapper.fromConnection(connectionService.updateConnection(connection));
    }

    public void deleteConnection(int id) throws Exception {
        connectionService.deleteConnection(id);
    }

}

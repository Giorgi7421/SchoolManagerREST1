package com.example.schoolmanagerrest.model.mappers;

import com.example.schoolmanagerrest.model.dto.ConnectionDTO;
import com.example.schoolmanagerrest.model.dto.CourseDTO;
import com.example.schoolmanagerrest.model.entity.Connection;
import com.example.schoolmanagerrest.model.entity.Course;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConnectionMapper {

    public static ConnectionDTO fromConnection(Connection connection) {
        if (connection == null)
            return null;
        ObjectMapper objectMapper = new ObjectMapper();
        ConnectionDTO dto = new ConnectionDTO();
        dto.setId(connection.getId());
        dto.setCourseId(connection.getCourseId());
        dto.setUserId(connection.getUserId());
        return dto;
    }

    public static List<ConnectionDTO> fromConnectionList(List<Connection> connections) {
        return connections.stream().map(ConnectionMapper::fromConnection).collect(Collectors.toList());
    }

}

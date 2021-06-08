package com.example.schoolmanagerrest.services;

import com.example.schoolmanagerrest.model.entity.Connection;
import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.repositories.ConnectionRepository;
import com.example.schoolmanagerrest.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConnectionService {

    @Autowired
    private ConnectionRepository connectionRepository;

    public List<Connection> getAllConnections() {
        return connectionRepository.findAll();
    }

    public Connection getConnectionByID(long id) throws Exception {
        Optional<Connection> optionalConnection = connectionRepository.findById(id);
        if (optionalConnection.isPresent()){
            return optionalConnection.get();
        }else{
            throw new Exception("Connection not found");
        }
    }

    public Connection createConnection(Connection connection){
        return connectionRepository.save(connection);
    }

    public Connection updateConnection(Connection connection){
        return connectionRepository.save(connection);
    }

    public void deleteConnection(Connection connection){
        connectionRepository.delete(connection);
    }
}

package com.example.schoolmanagerrest.repositories;

import com.example.schoolmanagerrest.model.entity.Connection;
import com.example.schoolmanagerrest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
}

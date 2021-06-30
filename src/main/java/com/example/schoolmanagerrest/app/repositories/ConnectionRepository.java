package com.example.schoolmanagerrest.app.repositories;

import com.example.schoolmanagerrest.app.model.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    @Transactional
    @Modifying
    @Query("update Connection co set co.isDeleted = true where co.id = :id")
    void markDeleted(long id);


    @Query("select co from Connection co where co.isDeleted = false")
    List<Connection> findAllMarked();
}

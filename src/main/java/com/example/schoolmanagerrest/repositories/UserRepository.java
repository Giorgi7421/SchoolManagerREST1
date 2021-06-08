package com.example.schoolmanagerrest.repositories;

import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.model.entity.SchoolUser;
import com.example.schoolmanagerrest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

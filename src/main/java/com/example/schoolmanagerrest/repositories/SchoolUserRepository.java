package com.example.schoolmanagerrest.repositories;

import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.model.entity.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolUserRepository extends JpaRepository<SchoolUser, Long> {
    @Query("select usr from Course cour join Connection con on cour.name = :course and cour.id = con.courseId join SchoolUser usr on con.userId = usr.id")
    List<SchoolUser> findUsersOfTheCourse(Course course);
}

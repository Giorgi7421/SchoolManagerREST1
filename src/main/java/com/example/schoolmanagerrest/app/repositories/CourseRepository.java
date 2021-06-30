package com.example.schoolmanagerrest.app.repositories;

import com.example.schoolmanagerrest.app.model.entity.Course;
import com.example.schoolmanagerrest.app.model.entity.SchoolUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select usr from Course cour join Connection con on cour.id = :id and cour.id = con.courseId join SchoolUser usr on con.userId = usr.id")
    List<SchoolUser> findUsersOfTheCourse(long id);

    @Query("select cou from Course cou where cou.startDate >= :start and cou.endDate <= :end")
    List<Course> findCoursesOnInterval(@Param("start") Date start , @Param("end") Date end);

    @Transactional
    @Modifying
    @Query("update Course c set c.isDeleted = true where c.id = :id")
    void markDeleted(long id);

    @Transactional
    @Modifying
    @Query("update Connection con set con.isDeleted = true where con.courseId = :id")
    void markDeletedConnections(long id);

    @Query("select c from Course c where c.isDeleted = false")
    List<Course> findAllMarked();

    @Query("select c from Course c where c.isDeleted = false and c.id = :id")
    Optional<Course> findByIdMarked(long id);

}

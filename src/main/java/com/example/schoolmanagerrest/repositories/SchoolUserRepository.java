package com.example.schoolmanagerrest.repositories;

import com.example.schoolmanagerrest.model.entity.Connection;
import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.model.entity.SchoolUser;
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
public interface SchoolUserRepository extends JpaRepository<SchoolUser, Long> {

    @Query("select cou from SchoolUser sch join Connection con on sch.id = con.userId and sch.id = :id join Course cou on con.courseId = cou.id")
    List<Course> findEnrolledCourses(@Param("id") long id);

    @Query("select cou from SchoolUser sch join Connection con on sch.id = con.userId and sch.firstName = :first and sch.lastName = :last join Course cou on con.courseId = cou.id")
    List<Course> findEnrolledCoursesByFirstAndLastName(@Param("first") String firstName , @Param("last") String lastName);

    @Query("select cou from Course cou where cou.startDate >= :start and cou.endDate <= :end")
    List<Course> findCoursesOnInterval(@Param("start") Date start , @Param("end") Date end);

    @Transactional
    @Modifying
    @Query("update SchoolUser su set su.isDeleted = true where su.id = :id")
    void markDeleted(long id);

    @Transactional
    @Modifying
    @Query("update Connection con set con.isDeleted = true where con.userId = :id")
    void markDeletedConnection(long id);

    @Query("select s from SchoolUser s where s.isDeleted = false")
    List<SchoolUser> findAllMarked();

    @Query("select su from SchoolUser su where su.isDeleted = false and su.id = :id")
    Optional<SchoolUser> findByIdMarked(long id);
}

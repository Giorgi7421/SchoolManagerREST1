package com.example.schoolmanagerrest.repositories;

import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.model.entity.SchoolUser;
import com.example.schoolmanagerrest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select cou from SchoolUser sch join Connection con on sch.id = con.userId and sch.id = :user join Course cou on con.courseId = cou.id")
    List<Course> findEnrolledCourses(@Param("user") SchoolUser user);

    @Query("select cou from SchoolUser sch join Connection con on sch.id = con.userId and sch.firstName = :first and sch.lastName = :last join Course cou on con.courseId = cou.id")
    List<Course> findEnrolledCoursesByFirstAndLastName(@Param("first") String firstName , @Param("last") String lastName);

    @Query("select cou from Course cou where cou.startDate >= :start and cou.endDate <= :end")
    List<Course> findCoursesOnInterval(@Param("start") Date start , @Param("end") Date end);
}

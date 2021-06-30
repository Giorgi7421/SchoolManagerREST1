package com.example.schoolmanagerrest.app.services;

import com.example.schoolmanagerrest.app.model.entity.Course;
import com.example.schoolmanagerrest.app.model.entity.SchoolUser;
import com.example.schoolmanagerrest.app.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAllMarked();
    }

    public Course getCourseByID(long id) throws Exception {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()){
            return optionalCourse.get();
        }else{
            throw new Exception("Course not found");
        }
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(int id){
        courseRepository.markDeleted(id);
        courseRepository.markDeletedConnections(id);
    }

    public List<SchoolUser> getAllUsers(long courseId) throws Exception {
        Optional<Course> optionalCourse = courseRepository.findByIdMarked(courseId);
        if (optionalCourse.isPresent()){
            return courseRepository.findUsersOfTheCourse(optionalCourse.get().getId());
        }else{
            throw new Exception("Course not found");
        }
    }

    public List<Course> getCoursesOnInterval(Date startDate , Date endDate){
        return courseRepository.findCoursesOnInterval(startDate , endDate);
    }

}

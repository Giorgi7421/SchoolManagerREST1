package com.example.schoolmanagerrest.app.facades;

import com.example.schoolmanagerrest.app.model.Params.Course.AddCourseParam;
import com.example.schoolmanagerrest.app.model.Params.Course.UpdateCourseParam;
import com.example.schoolmanagerrest.app.model.Params.Interval;
import com.example.schoolmanagerrest.app.model.dto.CourseDTO;
import com.example.schoolmanagerrest.app.model.dto.SchoolUserDTO;
import com.example.schoolmanagerrest.app.model.entity.Course;
import com.example.schoolmanagerrest.app.model.mappers.CourseMapper;
import com.example.schoolmanagerrest.app.model.mappers.SchoolUserMapper;
import com.example.schoolmanagerrest.app.services.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional( propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class CourseFacade {

    @Autowired
    private CourseService courseService;

    public List<CourseDTO> getAllCourses(){
        return CourseMapper.fromCourseList(courseService.getAllCourses());
    }

    public CourseDTO getCourseByID(int id) throws Exception {
        return CourseMapper.fromCourse(courseService.getCourseByID(id));
    }

    public CourseDTO createCourse(AddCourseParam addCourse) {
        ObjectMapper objectMapper = new ObjectMapper();

        Course course = new Course();

        course.setName(addCourse.getName());
        course.setDescription(addCourse.getDescription());
        course.setDeleted(false);
        course.setStartDate(addCourse.getStartDate());
        course.setEndDate(addCourse.getEndDate());

        return CourseMapper.fromCourse(courseService.createCourse(course));
    }

    public CourseDTO updateCourse(int id , UpdateCourseParam newCourse) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Course course = objectMapper.convertValue(newCourse, Course.class);
        course.setId(id);
        return CourseMapper.fromCourse(courseService.updateCourse(course));
    }

    public void deleteCourse(int id) throws Exception {
        courseService.deleteCourse(id);
    }

    public List<SchoolUserDTO> getAllUsers(int courseId) throws Exception {
        return SchoolUserMapper.fromSchoolUsersList(courseService.getAllUsers(courseId));
    }

    public List<CourseDTO> getCoursesOnInterval(Interval interval){
        return CourseMapper.fromCourseList(courseService.getCoursesOnInterval(interval.getStartDate() , interval.getEndDate()));
    };

}

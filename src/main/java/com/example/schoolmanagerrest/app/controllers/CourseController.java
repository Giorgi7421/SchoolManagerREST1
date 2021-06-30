package com.example.schoolmanagerrest.app.controllers;

import com.example.schoolmanagerrest.app.facades.CourseFacade;
import com.example.schoolmanagerrest.app.model.Params.Course.AddCourseParam;
import com.example.schoolmanagerrest.app.model.Params.Course.UpdateCourseParam;
import com.example.schoolmanagerrest.app.model.Params.Interval;
import com.example.schoolmanagerrest.app.model.dto.CourseDTO;
import com.example.schoolmanagerrest.app.model.dto.SchoolUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseFacade courseFacade;

    @GetMapping("/Course")
    public List<CourseDTO> getAllCourses() {
        return courseFacade.getAllCourses();
    }

    @GetMapping("/Course/{id}")
    public CourseDTO getCourseById(@PathVariable(value = "id") int id) throws Exception {
        return courseFacade.getCourseByID(id);
    }

    @PostMapping("/Course")
    public CourseDTO createCourse(@Valid @RequestBody AddCourseParam addCourseParam) {
        return courseFacade.createCourse(addCourseParam);
    }

    @PutMapping("/Course/{id}")
    public CourseDTO updateCourse(@PathVariable(value = "id") int id, @Valid @RequestBody UpdateCourseParam updateCourseParam) throws Exception {
        return courseFacade.updateCourse(id , updateCourseParam);
    }

    @DeleteMapping("/Course/{id}")
    public void deleteCourse(@PathVariable(value = "id") int id) throws Exception {
        courseFacade.deleteCourse(id);
    }

    @GetMapping("/Course/{id}/getUsers")
    public List<SchoolUserDTO> getAllUsers(@PathVariable(value = "id") int courseId) throws Exception {
        return courseFacade.getAllUsers(courseId);
    }

    @PostMapping("/Course/Interval")
    public List<CourseDTO> getCoursesOnInterval(@Valid @RequestBody Interval interval){
        return courseFacade.getCoursesOnInterval(interval);
    }

}

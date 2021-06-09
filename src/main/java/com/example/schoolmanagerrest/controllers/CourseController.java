package com.example.schoolmanagerrest.controllers;

import com.example.schoolmanagerrest.facades.CourseFacade;
import com.example.schoolmanagerrest.facades.SchoolUserFacade;
import com.example.schoolmanagerrest.model.Params.Course.AddCourseParam;
import com.example.schoolmanagerrest.model.Params.Course.UpdateCourseParam;
import com.example.schoolmanagerrest.model.Params.SchoolUser.AddSchoolUserParam;
import com.example.schoolmanagerrest.model.Params.SchoolUser.UpdateSchoolUserParam;
import com.example.schoolmanagerrest.model.dto.CourseDTO;
import com.example.schoolmanagerrest.model.dto.SchoolUserDTO;
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

}

package com.example.schoolmanagerrest.controllers;

import com.example.schoolmanagerrest.facades.SchoolUserFacade;
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
public class SchoolUserController {

    @Autowired
    private SchoolUserFacade schoolUserFacade;

    @GetMapping("/schoolUser")
    public List<SchoolUserDTO> getAllSchoolUsers() {
        return schoolUserFacade.getAllSchoolUsers();
    }

    @GetMapping("/schoolUser/{id}")
    public SchoolUserDTO getSchoolUserById(@PathVariable(value = "id") int id) throws Exception {
        return schoolUserFacade.getSchoolUserByID(id);
    }

    @PostMapping("/schoolUser")
    public SchoolUserDTO createSchoolUser(@Valid @RequestBody AddSchoolUserParam addSchoolUser) {
        return schoolUserFacade.createSchoolUser(addSchoolUser);
    }

    @PutMapping("/schoolUser/{id}")
    public SchoolUserDTO updateSchoolUser(@PathVariable(value = "id") int id, @Valid @RequestBody UpdateSchoolUserParam schoolUserDetails) throws Exception {
        return schoolUserFacade.updateSchoolUser(id , schoolUserDetails);
    }

    @DeleteMapping("/schoolUser/{id}")
    public void deleteSchoolUser(@PathVariable(value = "id") int id) throws Exception {
        schoolUserFacade.deleteSchoolUser(id);
    }

    @GetMapping("/schoolUser/{id}/getCourses")
    public List<CourseDTO> getCourses(@PathVariable(value = "id") int id) throws Exception {
        return schoolUserFacade.getAllCourses(id);
    }
}

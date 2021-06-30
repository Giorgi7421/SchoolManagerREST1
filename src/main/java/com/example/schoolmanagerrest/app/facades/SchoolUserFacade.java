/*package com.example.schoolmanagerrest.app.facades;

import com.example.schoolmanagerrest.app.model.Params.SchoolUser.AddSchoolUserParam;
import com.example.schoolmanagerrest.app.model.Params.SchoolUser.UpdateSchoolUserParam;
import com.example.schoolmanagerrest.app.model.dto.CourseDTO;
import com.example.schoolmanagerrest.app.model.dto.SchoolUserDTO;
import com.example.schoolmanagerrest.app.model.entity.SchoolUser;
import com.example.schoolmanagerrest.app.model.mappers.CourseMapper;
import com.example.schoolmanagerrest.app.model.mappers.SchoolUserMapper;
import com.example.schoolmanagerrest.app.services.SchoolUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional( propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class SchoolUserFacade {

    @Autowired
    private SchoolUserService schoolUserService;

    public List<SchoolUserDTO> getAllSchoolUsers(){
        return SchoolUserMapper.fromSchoolUsersList(schoolUserService.getAllSchoolUsers());
    }

    public SchoolUserDTO getSchoolUserByID(int id) throws Exception {
        return SchoolUserMapper.fromSchoolUser(schoolUserService.getSchoolUserByID(id));
    }

    public SchoolUserDTO createSchoolUser(AddSchoolUserParam addUser) {
        ObjectMapper objectMapper = new ObjectMapper();
        SchoolUser user = new SchoolUser();
        user.setFirstName(addUser.getFirstName());
        user.setLastName(addUser.getLastName());
        user.setMobileNumber(addUser.getMobileNumber());
        user.setUserName(addUser.getUserName());
        user.setDeleted(false);
        user.setPassword(addUser.getPassword());
        return SchoolUserMapper.fromSchoolUser(schoolUserService.createSchoolUser(user));
    }

    public SchoolUserDTO updateSchoolUser(int id , UpdateSchoolUserParam newUser) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        SchoolUser user = objectMapper.convertValue(newUser, SchoolUser.class);
        user.setId(id);
        return SchoolUserMapper.fromSchoolUser(schoolUserService.updateSchoolUser(user));
    }

    public void deleteSchoolUser(int id) throws Exception {
        schoolUserService.deleteSchoolUser(id);
    }

    public List<CourseDTO> getAllCourses(int id) throws Exception {
        return CourseMapper.fromCourseList(schoolUserService.getAllCourses(id));
    }
}*/

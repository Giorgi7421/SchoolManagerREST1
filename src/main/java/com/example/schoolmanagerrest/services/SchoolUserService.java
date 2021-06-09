package com.example.schoolmanagerrest.services;

import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.model.entity.SchoolUser;
import com.example.schoolmanagerrest.repositories.SchoolUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SchoolUserService {

    @Autowired
    private SchoolUserRepository schoolUserRepository;

    public List<SchoolUser> getAllSchoolUsers() {
        return schoolUserRepository.findAllMarked();
    }

    public SchoolUser getSchoolUserByID(long id) throws Exception {
        Optional<SchoolUser> optionalSchoolUser = schoolUserRepository.findById(id);
        if (optionalSchoolUser.isPresent()){
            return optionalSchoolUser.get();
        }else{
            throw new Exception("SchoolUser not found");
        }
    }

    public SchoolUser createSchoolUser(SchoolUser schoolUser){
        return schoolUserRepository.save(schoolUser);
    }

    public SchoolUser updateSchoolUser(SchoolUser schoolUser){
        return schoolUserRepository.save(schoolUser);
    }

    public void deleteSchoolUser(int id){
        schoolUserRepository.markDeleted(id);
        schoolUserRepository.markDeletedConnection(id);
    }

    public List<Course> getAllCourses(long schoolUserId) throws Exception {
        Optional<SchoolUser> optionalSchoolUser = schoolUserRepository.findByIdMarked(schoolUserId);
        if (optionalSchoolUser.isPresent()){
            return schoolUserRepository.findEnrolledCourses(optionalSchoolUser.get().getId());
        }else{
            throw new Exception("SchoolUser not found");
        }
    }
}

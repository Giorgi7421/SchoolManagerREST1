package com.example.schoolmanagerrest.services;

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
        return schoolUserRepository.findAll();
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

    public void deleteSchoolUser(SchoolUser schoolUser){
        schoolUserRepository.delete(schoolUser);
    }
}

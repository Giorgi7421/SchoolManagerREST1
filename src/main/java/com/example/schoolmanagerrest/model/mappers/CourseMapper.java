package com.example.schoolmanagerrest.model.mappers;

import com.example.schoolmanagerrest.model.dto.CourseDTO;
import com.example.schoolmanagerrest.model.dto.SchoolUserDTO;
import com.example.schoolmanagerrest.model.entity.Course;
import com.example.schoolmanagerrest.model.entity.SchoolUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseDTO fromCourse(Course course) {
        if (course == null)
            return null;
        ObjectMapper objectMapper = new ObjectMapper();
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setEndDate(course.getEndDate());
        dto.setStartDate(course.getStartDate());
        return dto;
    }

    public static List<CourseDTO> fromCourseList(List<Course> courses) {
        return courses.stream().map(CourseMapper::fromCourse).collect(Collectors.toList());
    }

}

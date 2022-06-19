package com.evl.employeeaccounting.managers.course;

import com.evl.employeeaccounting.controllers.dto.CourseFullDto;
import com.evl.employeeaccounting.controllers.dto.CourseShortDto;
import com.evl.employeeaccounting.entityes.EducationCourse;
import com.evl.employeeaccounting.services.implimentation.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class CourseManager implements ICourseManager{

    private CourseService courseService;


    @Override
    public List<CourseFullDto> findAllDto() {
        return null;
    }

    @Override
    public CourseFullDto toCourseFullDto(EducationCourse course) {
        return null;
    }

    @Override
    public CourseShortDto toCourseShortDto(EducationCourse course) {
        return CourseShortDto.builder()
                .id(course.getId())
                .name(course.getName())
                .startDate(course.getStartDate())
                .endDate(course.getFinishDate())
                .build();
    }
}

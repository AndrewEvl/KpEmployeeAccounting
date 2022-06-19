package com.evl.employeeaccounting.managers.course;

import com.evl.employeeaccounting.controllers.dto.CourseFullDto;
import com.evl.employeeaccounting.controllers.dto.CourseShortDto;
import com.evl.employeeaccounting.entityes.EducationCourse;

import java.util.List;

public interface ICourseManager {

    List<CourseFullDto> findAllDto();

    CourseFullDto toCourseFullDto(EducationCourse course);

    CourseShortDto toCourseShortDto(EducationCourse course);
}

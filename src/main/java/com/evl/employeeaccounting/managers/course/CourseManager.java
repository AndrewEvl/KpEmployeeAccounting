package com.evl.employeeaccounting.managers.course;

import com.evl.employeeaccounting.controllers.dto.CourseChangeDto;
import com.evl.employeeaccounting.controllers.dto.CourseFullDto;
import com.evl.employeeaccounting.controllers.dto.CourseShortDto;
import com.evl.employeeaccounting.entityes.EducationCourse;
import com.evl.employeeaccounting.entityes.Employee;
import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.managers.employee.EmployeeManager;
import com.evl.employeeaccounting.services.implimentation.CourseService;
import com.evl.employeeaccounting.services.implimentation.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CourseManager implements ICourseManager {

    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeManager employeeManager;
    @Autowired
    private EmployeeService employeeService;


    @Override
    public List<CourseFullDto> findAllDto() {
        return courseService.findAll()
                .stream()
                .map(this::toCourseFullDto)
                .toList();
    }

    @Override
    public CourseFullDto toCourseFullDto(EducationCourse course) {
        return CourseFullDto.builder()
                .id(course.getId())
                .name(course.getName())
                .startDate(course.getStartDate())
                .endDate(course.getFinishDate())
                .employeeList(course.getEmployeeList()
                        .stream()
                        .map(employeeManager::toEmployeeShortDto).toList())
                .build();
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

    @Override
    public CourseFullDto save(CourseChangeDto courseDto) {
        EducationCourse course;

        if (courseDto.getId() == null) {
            course = new EducationCourse();
        } else {
            Optional<EducationCourse> courseOptional = courseService.findById(courseDto.getId());
            if (courseOptional.isPresent()) {
                course = courseOptional.get();
            } else {
                throw new ApplicationException(500, "Курс не найден");
            }
        }

        course.setName(courseDto.getName());
        course.setStartDate(courseDto.getStartDate());
        course.setFinishDate(courseDto.getEndDate());

        if (!courseDto.getAddEmployee().isEmpty()) {
            List<Employee> employeeListAdd = employeeService.findAllByIds(courseDto.getAddEmployee());
            List<Employee> employeeList = course.getEmployeeList();
            employeeList.addAll(employeeListAdd);
            course.setEmployeeList(employeeList);
        }
        if (!courseDto.getMinusEmployee().isEmpty()) {
            List<Employee> newEmployeeList = course.getEmployeeList()
                    .stream()
                    .filter(employee ->
                            !courseDto.getMinusEmployee().contains(employee.getId()))
                    .toList();

            course.setEmployeeList(newEmployeeList);
        }

        return toCourseFullDto(courseService.save(course));
    }

    @Override
    public CourseFullDto getById(Long id) {
        Optional<EducationCourse> courseOptional = courseService.findById(id);
        if (courseOptional.isPresent()) {
            return toCourseFullDto(courseOptional.get());
        } else {
            throw new ApplicationException(500, "Курсы не найдены");
        }
    }

    @Override
    public void delete(Long id) {
        courseService.deleteById(id);
    }
}

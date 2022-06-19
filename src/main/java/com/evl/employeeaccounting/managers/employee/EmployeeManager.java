package com.evl.employeeaccounting.managers.employee;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.controllers.dto.CourseShortDto;
import com.evl.employeeaccounting.controllers.dto.EmployeeChangeDto;
import com.evl.employeeaccounting.controllers.dto.EmployeeFullDto;
import com.evl.employeeaccounting.controllers.dto.EmployeeShortDto;
import com.evl.employeeaccounting.entityes.Department;
import com.evl.employeeaccounting.entityes.EducationCourse;
import com.evl.employeeaccounting.entityes.Employee;
import com.evl.employeeaccounting.entityes.EmployeeStatus;
import com.evl.employeeaccounting.entityes.Position;
import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.managers.course.CourseManager;
import com.evl.employeeaccounting.services.implimentation.CourseService;
import com.evl.employeeaccounting.services.implimentation.DepartmentService;
import com.evl.employeeaccounting.services.implimentation.EmployeeService;
import com.evl.employeeaccounting.services.implimentation.PositionService;
import com.evl.employeeaccounting.services.implimentation.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@Transactional
@AllArgsConstructor
public class EmployeeManager implements IEmployeeManager {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final StatusService statusService;
    private final CourseService courseService;
    private final CourseManager courseManager;

    @Override
    public List<EmployeeFullDto> findAllDto() {
        return employeeService.findAll()
                .stream()
                .map(this::toEmployeeFullDto)
                .collect(toList());
    }

    public EmployeeFullDto toEmployeeFullDto(Employee employee) {
        EmployeeStatus status = employee.getStatus();
        Department department = employee.getDepartment();
        Position position = employee.getPosition();
        List<CourseShortDto> courseDtoList = employee.getCourseList().stream().map(courseManager::toCourseShortDto).toList();

        return EmployeeFullDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .surname(employee.getSurname())
                .birthday(employee.getBirthday())
                .department(BaseData.builder()
                        .id(department.getId())
                        .name(department.getName())
                        .build())
                .status(BaseData.builder()
                        .id(status.getId())
                        .name(status.getName())
                        .build())
                .position(BaseData.builder()
                        .id(position.getId())
                        .name(position.getName())
                        .build())
                .courseList(courseDtoList)
                .build();
    }

    @Override
    public EmployeeShortDto toEmployeeShortDto(Employee employee) {
        EmployeeStatus status = employee.getStatus();
        Department department = employee.getDepartment();
        Position position = employee.getPosition();
        return EmployeeShortDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .surname(employee.getSurname())
                .birthday(employee.getBirthday())
                .department(BaseData.builder()
                        .id(department.getId())
                        .name(department.getName())
                        .build())
                .status(BaseData.builder()
                        .id(status.getId())
                        .name(status.getName())
                        .build())
                .position(BaseData.builder()
                        .id(position.getId())
                        .name(position.getName())
                        .build())
                .build();
    }

    @Override
    public EmployeeFullDto save(EmployeeChangeDto employeeDto) {
        Employee employee;

        if (employeeDto.getId() == null) {
            employee = new Employee();
        } else {
            Optional<Employee> employeeOptional = employeeService.findById(employeeDto.getId());
            if (employeeOptional.isPresent()) {
                employee = employeeOptional.get();
            } else {
                throw new ApplicationException(500, "Сотредник не найден");
            }
        }

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setSurname(employeeDto.getSurname());
        employee.setBirthday(employeeDto.getBirthday());

        if (employeeDto.getDepartmentId() != null) {

            departmentService.findById(employeeDto.getDepartmentId())
                    .ifPresentOrElse(
                            employee::setDepartment,
                            () -> {
                                throw new ApplicationException(500, "Отдел ненайден");
                            });
        }

        if (employeeDto.getPositionId() != null) {
            positionService.findById(employeeDto.getPositionId())
                    .ifPresentOrElse(
                            employee::setPosition,
                            () -> {
                                throw new ApplicationException(500, "Должность ненайдена");
                            });
        }

        if (employeeDto.getStatusId() != null) {
            statusService.findById(employeeDto.getStatusId())
                    .ifPresentOrElse(
                            employee::setStatus,
                            () -> {
                                throw new ApplicationException(500, "Статус ненайден");
                            });
        }

        if (!employeeDto.getAddCourse().isEmpty()) {
            List<EducationCourse> courseListAdd = courseService.findAllByIds(employeeDto.getAddCourse());
            List<EducationCourse> courseList = employee.getCourseList();
            courseList.addAll(courseListAdd);
            employee.setCourseList(courseList);
        }
        if (!employeeDto.getMinusCourse().isEmpty()) {
            List<EducationCourse> newCourseList = employee.getCourseList()
                    .stream()
                    .filter(course ->
                            !employeeDto.getMinusCourse().contains(course.getId()))
                    .toList();

            employee.setCourseList(newCourseList);
        }

        employee = employeeService.save(employee);
        return toEmployeeFullDto(employee);
    }

    @Override
    public void delete(Long id) {
        employeeService.deleteById(id);
    }

    @Override
    public EmployeeFullDto getById(Long id) {
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (employeeOptional.isPresent()) {
            return toEmployeeFullDto(employeeOptional.get());
        } else {
            throw new ApplicationException(500, "Сотрудник ненайден");
        }
    }
}

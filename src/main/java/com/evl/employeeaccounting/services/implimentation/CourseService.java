package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.EducationCourse;
import com.evl.employeeaccounting.repositories.CourseRepository;
import com.evl.employeeaccounting.services.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService extends AbstractService<EducationCourse, CourseRepository> {

    public CourseService(CourseRepository repository) {
        super(repository);
    }
}

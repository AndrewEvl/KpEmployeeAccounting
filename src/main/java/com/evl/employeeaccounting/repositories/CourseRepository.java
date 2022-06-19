package com.evl.employeeaccounting.repositories;

import com.evl.employeeaccounting.entityes.EducationCourse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CourseRepository extends AbstractRepository<EducationCourse> {
}

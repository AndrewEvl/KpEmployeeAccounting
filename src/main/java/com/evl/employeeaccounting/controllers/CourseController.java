package com.evl.employeeaccounting.controllers;

import com.evl.employeeaccounting.managers.course.CourseManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping({"course"})
public class CourseController {

    private final CourseManager courseManager;
}

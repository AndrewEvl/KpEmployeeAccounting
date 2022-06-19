package com.evl.employeeaccounting.controllers;

import com.evl.employeeaccounting.controllers.dto.CourseChangeDto;
import com.evl.employeeaccounting.controllers.dto.CourseFullDto;
import com.evl.employeeaccounting.managers.course.CourseManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping({"course"})
public class CourseController {

    private final CourseManager courseManager;

    @GetMapping(value = "/get-all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(courseManager.findAllDto());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody CourseChangeDto changeDto){
        CourseFullDto resp = courseManager.save(changeDto);
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAll(@PathVariable("id") Long id) {
        CourseFullDto resp = courseManager.getById(id);
        return ResponseEntity.ok().body(resp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        courseManager.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}

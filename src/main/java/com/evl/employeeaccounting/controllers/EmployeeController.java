package com.evl.employeeaccounting.controllers;

import com.evl.employeeaccounting.managers.enployee.IEmployeeManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping({"employee"})
public class EmployeeController {

    private final IEmployeeManager employeeManager;

    @GetMapping(value = "/get-all")
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(employeeManager.findAll());
    }

}

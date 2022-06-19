package com.evl.employeeaccounting.controllers;

import com.evl.employeeaccounting.controllers.dto.EmployeeChangeDto;
import com.evl.employeeaccounting.controllers.dto.EmployeeFullDto;
import com.evl.employeeaccounting.managers.employee.IEmployeeManager;
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
@RequestMapping({"employee"})
public class EmployeeController {

    private final IEmployeeManager employeeManager;

    @GetMapping(value = "/get-all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(employeeManager.findAllDto());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody EmployeeChangeDto employeeDto){
       EmployeeFullDto resp = employeeManager.save(employeeDto);
       return ResponseEntity.ok().body(resp);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAll(@PathVariable("id") Long id) {
        EmployeeFullDto resp = employeeManager.getById(id);
        return ResponseEntity.ok().body(resp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        employeeManager.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }

}

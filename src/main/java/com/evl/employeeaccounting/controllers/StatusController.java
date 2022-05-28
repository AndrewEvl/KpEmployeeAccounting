package com.evl.employeeaccounting.controllers;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.controllers.dto.NameDto;
import com.evl.employeeaccounting.entityes.EmployeeStatus;
import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.exeptions.ExceptionResponse;
import com.evl.employeeaccounting.managers.status.StatusManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping({"status"})
public class StatusController {

    private final StatusManager statusManager;

    @GetMapping("get-all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok()
                .body(statusManager.findAllDto());
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody NameDto rq) {
        EmployeeStatus status = statusManager.save(rq.getName());
        if (status != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody BaseData rq) {
        EmployeeStatus status = statusManager.update(rq.getId(), rq.getName());
        if (status != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            statusManager.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (ApplicationException e) {
            return ResponseEntity.status(409)
                    .body(
                            ExceptionResponse.builder()
                                    .message(e.getMessage())
                                    .build());
        }
    }
}

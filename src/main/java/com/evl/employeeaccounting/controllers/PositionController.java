package com.evl.employeeaccounting.controllers;

import com.evl.employeeaccounting.controllers.dto.BaseData;
import com.evl.employeeaccounting.entityes.Position;
import com.evl.employeeaccounting.managers.IPositionManager;
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
@RequestMapping({"position"})
public class PositionController {

    private final IPositionManager positionManager;

    @GetMapping("get-all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok()
                .body(positionManager.findAllDto());
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody BaseData rq) {
        Position position = positionManager.save(rq.getName());
        if (position != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody BaseData rq) {
        Position position = positionManager.update(rq.getId(), rq.getName());
        if (position != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        positionManager.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

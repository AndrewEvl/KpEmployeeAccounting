package com.evl.employeeaccounting.entityes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "employee_status", schema = "employee_accounting")
public class EmployeeStatus {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

}

package com.evl.employeeaccounting.entityes;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Table(name = "education_employee", schema = "employee_accounting")
@IdClass(EducationEmployeePK.class)
public class EducationEmployee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "education_id", nullable = false)
    private int educationId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "employee_id", nullable = false)
    private int employeeId;

}

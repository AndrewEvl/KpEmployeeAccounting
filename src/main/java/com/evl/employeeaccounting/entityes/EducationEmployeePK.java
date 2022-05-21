package com.evl.employeeaccounting.entityes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EducationEmployeePK implements Serializable {
    @Column(name = "education_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationId;
    @Column(name = "employee_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationEmployeePK that = (EducationEmployeePK) o;
        return educationId == that.educationId && employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationId, employeeId);
    }
}

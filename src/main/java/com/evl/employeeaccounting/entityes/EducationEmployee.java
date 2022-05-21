package com.evl.employeeaccounting.entityes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "education_employee", schema = "employee_accounting", catalog = "")
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
        EducationEmployee that = (EducationEmployee) o;
        return educationId == that.educationId && employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(educationId, employeeId);
    }
}

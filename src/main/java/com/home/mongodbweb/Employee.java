package com.home.mongodbweb;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Indexed;

import java.util.Date;

/**
 * Created by Александр on 11.11.2018.
 */
public class Employee {

    @Id
    private Long id;

    private String empNo;

    private String fullName;

    private Date hireDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "id:"+ this.id+", empNo:"+empNo+", fullName:"+ this.fullName+", hireDate:"+this.hireDate;
    }
}

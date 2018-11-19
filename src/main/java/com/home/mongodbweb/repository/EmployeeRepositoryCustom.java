package com.home.mongodbweb.repository;

import java.util.Date;

/**
 * Created by Александр on 11.11.2018.
 */
public interface EmployeeRepositoryCustom {
    long getMaxEmpId();
    long updateEmployee(String empNo, String fullName, Date hireDate);
}

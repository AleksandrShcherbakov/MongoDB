package com.home.mongodbweb.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Александр on 11.11.2018.
 */
@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    //MongoTemplate

    @Override
    public long getMaxEmpId() {
        return 0;
    }

    @Override
    public long updateEmployee(String empNo, String fullName, Date hireDate) {
        return 0;
    }
}

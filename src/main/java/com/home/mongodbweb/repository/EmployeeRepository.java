package com.home.mongodbweb.repository;

import com.home.mongodbweb.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by Александр on 11.11.2018.
 */
public interface EmployeeRepository extends MongoRepository<Employee, Long> {
    Employee findByEmpNo(String empNo);

    List<Employee> findByFullNameLike(String fullName);

    List<Employee> findByHireDateGreaterThan(Date hireDate);

    @Query("{fullName:'?0'}")
    List<Employee> findCustomByFullName(String fullName);
}

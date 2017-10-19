package com.blibli.repository;

import com.blibli.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Dias on 10/19/2017.
 */
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> data = this.entityManager.createNativeQuery(
                "SELECT * FROM Employee", Employee.class).getResultList();
        return data;
    }
}

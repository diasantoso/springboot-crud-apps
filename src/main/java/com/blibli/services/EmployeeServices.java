package com.blibli.services;

import com.blibli.model.Employee;
import com.blibli.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dias on 1/30/2017.
 */
@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> showEmp() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }

    public Employee saveOrUpdate(Employee e) {
        Employee cek = employeeRepository.save(e);
        return cek;
    }

    public Employee getIdEmp(Integer id) {
        Employee get = employeeRepository.findOne(id);
        return get;
    }

    public void hapus(Integer id) {
        employeeRepository.delete(id);
    }
}

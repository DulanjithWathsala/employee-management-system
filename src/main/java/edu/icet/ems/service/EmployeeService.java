package edu.icet.ems.service;

import edu.icet.ems.entity.EmployeeEntity;
import edu.icet.ems.model.Employee;

public interface EmployeeService {

    EmployeeEntity persist(Employee employee);

    Iterable<Employee> retrieveAll();

    Employee findById(Integer id);

    void deleteById(Integer id);
}

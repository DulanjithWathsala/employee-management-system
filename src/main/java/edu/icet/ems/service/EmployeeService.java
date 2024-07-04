package edu.icet.ems.service;

import edu.icet.ems.entity.EmployeeEntity;
import edu.icet.ems.model.Employee;

public interface EmployeeService {

    Employee persist(Employee employee);

    Iterable<Employee> retrieveAll();

    Employee findById(Integer id);

    Employee findByEmail(String email);

    void deleteById(Integer id);


}

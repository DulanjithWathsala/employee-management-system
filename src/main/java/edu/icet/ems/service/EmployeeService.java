package edu.icet.ems.service;

import edu.icet.ems.entity.EmployeeEntity;
import edu.icet.ems.model.Employee;

public interface EmployeeService {

    Employee persist(Employee employee);

    Iterable<Employee> retrieveAll();

    Employee findById(Long id);

    Employee findByEmail(String email);

    String deleteById(Long id);


}

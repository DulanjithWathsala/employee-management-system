package edu.icet.ems.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.ems.entity.EmployeeEntity;
import edu.icet.ems.model.Employee;
import edu.icet.ems.repository.EmployeeRepository;
import edu.icet.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ObjectMapper mapper;

    @Override
    public EmployeeEntity persist(Employee employee) {
        return employeeRepository.save(
                mapper.convertValue(employee, EmployeeEntity.class));
    }

    @Override
    public Iterable<Employee> retrieveAll() {
        Iterable<EmployeeEntity> entities = employeeRepository.findAll();

        List<Employee> employeeList = new ArrayList<>();
        entities.forEach(employeeEntity -> employeeList.add(
                mapper.convertValue(
                        employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}

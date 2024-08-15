package edu.icet.ems.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.ems.entity.EmployeeEntity;
import edu.icet.ems.exception.EmployeeAlreadyExistException;
import edu.icet.ems.exception.EmployeeNotFoundException;
import edu.icet.ems.exception.ParameterNotFoundException;
import edu.icet.ems.model.Employee;
import edu.icet.ems.repository.EmployeeJpaRepository;
import edu.icet.ems.service.EmployeeService;
import edu.icet.ems.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final ObjectMapper mapper;

    @Override
    public Employee persist(Employee employee) {
        if (employeeJpaRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new EmployeeAlreadyExistException("Employee already exist with same email!");
        }

        return mapper.convertValue(employeeJpaRepository.save(
                        mapper.convertValue(employee, EmployeeEntity.class)),
                Employee.class);
    }

    @Override
    public Iterable<Employee> retrieveAll() {
        Iterable<EmployeeEntity> entities = employeeJpaRepository.findAll();

        List<Employee> employeeList = new ArrayList<>();
        entities.forEach(employeeEntity -> employeeList.add(
                mapper.convertValue(employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public Employee findById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeJpaRepository.findById(id);
        if (employeeEntity.isPresent()) {
            return mapper.convertValue(employeeEntity , Employee.class);
        }
        return null;
    }

    @Override
    public Employee findByEmail(String email) {
        if (EmailValidator.isValidEmail(email)) {
            Optional<EmployeeEntity> employeeEntity = employeeJpaRepository.findByEmail(email);
            if (employeeEntity.isPresent()) {
                return mapper.convertValue(employeeEntity.get() , Employee.class);
            }
        }
        return null;
    }

    @Override
    public String deleteById(Long id) {
        if (employeeJpaRepository.existsById(id)) {
            employeeJpaRepository.deleteById(id);
            return "Success";
        }
        return "Failed";
    }

    @Override
    public Employee findByFirstName(String firstName) {
        if (!StringUtils.hasText(firstName)) {
            throw new ParameterNotFoundException("First name can't be empty!");
        }

        Optional<EmployeeEntity> employeeEntity = employeeJpaRepository.findByFirstName(firstName);
        if (employeeEntity.isEmpty()) {
            throw new EmployeeNotFoundException("Customer Not Found");
        }

        return mapper.convertValue(employeeEntity.get(), Employee.class);
    }

    @Override
    public Employee update(Employee employee) {
        return mapper.convertValue(
                employeeJpaRepository.save(mapper.convertValue(employee, EmployeeEntity.class)),
                Employee.class);
    }
}

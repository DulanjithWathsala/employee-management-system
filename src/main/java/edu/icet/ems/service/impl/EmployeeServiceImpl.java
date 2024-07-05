package edu.icet.ems.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.ems.entity.EmployeeEntity;
import edu.icet.ems.model.Employee;
import edu.icet.ems.repository.EmployeeJpaRepository;
import edu.icet.ems.service.EmployeeService;
import edu.icet.ems.utils.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final ObjectMapper mapper;

    @Override
    public Employee persist(Employee employee) {
        if (EmailValidator.isValidEmail(employee.getEmail())) {
            return mapper.convertValue(employeeJpaRepository.save(
                            mapper.convertValue(employee, EmployeeEntity.class))
                    , Employee.class);
        }
        return null;
    }

    @Override
    public Iterable<Employee> retrieveAll() {
        Iterable<EmployeeEntity> entities = employeeJpaRepository.findAll();

        List<Employee> employeeList = new ArrayList<>();
        entities.forEach(employeeEntity -> employeeList.add(
                mapper.convertValue(
                        employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public Employee findByEmail(String email) {
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
}

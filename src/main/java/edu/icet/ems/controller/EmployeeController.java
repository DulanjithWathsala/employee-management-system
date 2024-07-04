package edu.icet.ems.controller;

import edu.icet.ems.model.Employee;
import edu.icet.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping()
    Employee persist(@RequestBody Employee employee) {
        return employeeService.persist(employee);
    }

    @GetMapping("/all")
    Iterable<Employee> retrieveAll() {
        return employeeService.retrieveAll();
    }

    @GetMapping()
    Employee retrieveById(@RequestParam Integer id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }
}

package edu.icet.ems.controller;

import edu.icet.ems.model.Employee;
import edu.icet.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping()
    public Employee persist(@RequestBody Employee employee) {
        return employeeService.persist(employee);
    }

    @GetMapping("/all")
    public Iterable<Employee> retrieveAll() {
        return employeeService.retrieveAll();
    }

    @GetMapping("/by-email")
    public Employee retrieveByEmail(@RequestParam String email) {
        return employeeService.findByEmail(email);
    }

    @GetMapping("/{id}")
    public Employee retrieveById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        return Collections.singletonMap(
                "Delete", employeeService.deleteById(id));
    }
}

package edu.icet.ems.controller;

import edu.icet.ems.model.Department;
import edu.icet.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/all-names")
    public List<String> retrieveAllNames() {
        return departmentService.retrieveDepartmentNames();
    }

    @GetMapping("/all")
    public List<Department> retrieveAll() {
        return departmentService.retrieveAll();
    }
}

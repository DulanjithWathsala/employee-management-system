package edu.icet.ems.service;

import edu.icet.ems.model.Department;

import java.util.List;

public interface DepartmentService {

    List<String> retrieveDepartmentNames();

    List<Department> retrieveAll();
}
